import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_07330_SocketServer_A08 {
    private static final int PORT = 8080;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform integrity check on the socket here.
                // If the integrity check fails, close the socket.
                // This is a placeholder, not a real security-sensitive operation.
                if (socketIntegrityCheck(socket)) {
                    service.execute(new ClientHandler(socket));
                } else {
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred while accepting connection: " + e);
        } finally {
            service.shutdown();
        }
    }

    // Simplified example of a client handler. Actual implementation could be more complex.
    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_07330_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client's request here.
            // This is a placeholder, not a real security-sensitive operation.
            try {
                // Simulate some latency
                Thread.sleep(5000);

                System.out.println("Handling request from " + socket.getRemoteSocketAddress());
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e);
            }
        }
    }

    // Placeholder method for simplicity. In a real implementation, you would have
    // a more sophisticated method to perform the integrity check.
    private static boolean socketIntegrityCheck(Socket socket) {
        // This is a placeholder, not a real security-sensitive operation.
        return true;
    }
}