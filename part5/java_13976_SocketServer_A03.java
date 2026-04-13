import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_13976_SocketServer_A03 {

    // Define server port
    private static final int SERVER_PORT = 8080;

    // SocketServer instance
    private static ServerSocket server;

    // ExecutorService to manage multiple threads
    private static ExecutorService executor;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        executor = Executors.newFixedThreadPool(10);

        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port: " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                // Create new thread for each client connection
                Handler handler = new Handler(client);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Shutdown executor
            executor.shutdown();
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_13976_SocketServer_A03(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    // Check for known commands
                    if (message.equalsIgnoreCase("QUIT")) {
                        socket.close();
                        System.out.println("Client disconnected");
                        return;
                    }

                    // Handle received message
                    handleMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handleMessage(String message) {
            // TODO: Implement message handling and security-sensitive operations
            // This is a placeholder and should be replaced with actual implementation.
            System.out.println("Received: " + message);
        }
    }
}