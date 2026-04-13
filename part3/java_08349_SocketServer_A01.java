import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08349_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(socket));
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
            if (executor != null) {
                executor.shutdown();
            }
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_08349_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        out.writeBytes("exit\n");
                        socket.close();
                        return;
                    }
                    out.writeBytes("ACK " + message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}