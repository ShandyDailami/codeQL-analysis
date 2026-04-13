import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11002_SocketServer_A03 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {

        // Create a new executor service with a single thread for handling connections
        executorService = Executors.newSingleThreadExecutor();

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Start the server
        startServer(serverSocket);
    }

    private static void startServer(ServerSocket serverSocket) {
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                // Accept a new client connection
                Socket clientSocket = serverSocket.accept();

                // Start a new thread to handle the client connection
                executorService.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                System.err.println("Failed to accept a client connection: " + e.getMessage());
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_11002_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Get the input and output streams from the client socket
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // Read the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String request = reader.readLine();

                // Process the request (this is a placeholder for a real application)
                processRequest(request);

                // Send a response back to the client
                outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                outputStream.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                outputStream.write("\r\n".getBytes());
                outputStream.write("Hello, World! (Processed)".getBytes());
                outputStream.flush();

                // Close the client socket
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Failed to handle client connection: " + e.getMessage());
            }
        }

        private void processRequest(String request) {
            // This is where the injection attack occurs. 
            // The request parameter can be manipulated to include harmful content.
            // For example, request = "username=1' OR '1=1" could potentially bypass authentication and lead to arbitrary code execution.
        }
    }
}