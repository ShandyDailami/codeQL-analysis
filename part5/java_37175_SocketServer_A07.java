import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37175_SocketServer_A07 {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_37175_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMsg = reader.readLine();
                System.out.println("Received: " + clientMsg);

                String[] parts = clientMsg.split(" ");
                if ("admin".equals(parts[0]) && "password".equals(parts[1])) {
                    writer.write(("Authentication successful\r\n").getBytes());
                    writer.flush();
                } else {
                    writer.write(("Authentication failed\r\n").getBytes());
                    writer.flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}