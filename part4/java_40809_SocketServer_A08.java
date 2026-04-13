import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40809_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_40809_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(input);

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received: " + clientMessage);

                if (clientMessage.equals("exit")) {
                    socket.close();
                } else {
                    // Assuming client is sending 'OK' response
                    DataOutputStream output = socket.getOutputStream();
                    output.writeUTF("OK");
                    output.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}