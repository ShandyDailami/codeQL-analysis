import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24468_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());
            handleConnection(socket);
        }
    }

    private static void handleConnection(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_24468_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Hello, client!");
                }
            } catch (IOException e) {
                e.printStackTrace();
           
            }

            closeConnection();
        }

        private void closeConnection() {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        socket.close();
                        reader.close();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}