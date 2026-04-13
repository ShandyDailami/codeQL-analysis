import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25586_SocketServer_A07 {
    private static ExecutorService executorService;
    private static int port = 12345;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(5);

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client has connected");

                Runnable clientHandler = new ClientHandler(clientSocket);
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            System.out.println("Error setting up the server socket: " + e.getMessage());
        }

        executorService.shutdown();
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                 BufferedReader reader = new BufferedReader(in)) {

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    // Perform some authentication operation
                    if (!authenticate(request)) {
                        sendResponse(clientSocket, "Authentication failed");
                        return;
                    }

                    sendResponse(clientSocket, "Authentication successful");
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }

        private boolean authenticate(String request) {
            // Implementation of security-sensitive operations related to A07_AuthFailure
            // This is a placeholder for the actual implementation
            return true;
        }

        private void sendResponse(Socket clientSocket, String response) {
            try (OutputStream out = clientSocket.getOutputStream()) {
                out.write((response + "\n").getBytes());
                out.flush();
            } catch (IOException e) {
                System.out.println("Error sending response: " + e.getMessage());
            }
        }
    }
}