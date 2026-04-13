import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_23861_SocketServer_A07 {
    private static final int PORT = 6000;
    private static final String HOST = "localhost";
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);

        // Start the server
        startServer();

        // Create clients
        createClients();

        // End the server
        endServer();
    }

    private static void startServer() {
        new Thread(() -> {
            try {
                // Bind the socket to the port
                java.net.ServerSocket server = new java.net.ServerSocket(PORT);
                System.out.println("Server started");

                while (true) {
                    // Accept a client connection
                    Socket socket = server.accept();

                    // Create a new thread for the client
                    ClientHandler clientHandler = new ClientHandler(socket);
                    executorService.submit(clientHandler);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void createClients() {
        // Create and start client threads
        for (int i = 0; i < 10; i++) {
            new ClientThread().start();
        }
    }

    private static void endServer() {
        executorService.shutdown();
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_23861_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client connection and send/receive data
        }
    }

    static class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                // Connect to the server
                Socket socket = new Socket(HOST, PORT);

                // TODO: Send/receive data

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}