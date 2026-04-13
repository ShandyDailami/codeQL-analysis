import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37051_SocketServer_A03 {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                try {
                    Socket client = server.accept();
                    System.out.println("New client connected: " + client.getRemoteSocketAddress());

                    // Process the request
                    executorService.execute(new ClientHandler(client));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_37051_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Perform security-sensitive operation related to Injection
                    String sanitizedRequest = sanitizeInput(request);

                    out.println("Response from server: " + sanitizedRequest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String sanitizeInput(String input) {
            // Add code to sanitize the input for security reasons
            // This will depend on the specific use case and the libraries used
            // For example, you might want to prevent SQL injection or similar attacks
            // The actual implementation would depend on the specific security requirements
            // and the libraries used in the application.
            // This example simply returns the input as is.
            return input;
        }
    }
}