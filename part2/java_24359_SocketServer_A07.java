import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24359_SocketServer_A07 {
    private static final int PORT = 5000;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT + "...");
            while (true) {
                try {
                    Socket clientSocket = server.accept();
                    System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());
                    Handler handler = new Handler(clientSocket);
                    executorService.execute(handler);
                } catch (IOException e) {
                    System.out.println("Client connection failed: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + PORT + ": " + e.getMessage());
            System.exit(-1);
        }
    }

    static class Handler implements Runnable {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    if (checkAuthFailure(request)) {
                        writer.println("Auth failed, please try again");
                        writer.flush();
                        break; // break the loop after sending a response
                    }
                    writer.println("Auth successful, welcome back!");
                    writer.flush();
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }

        private boolean checkAuthFailure(String request) {
            // Implementation of authentication failure check
            // This can be a complex operation that depends on your specific use case
            // You can use external libraries like Hibernate or Spring Security for authentication
            // This is a simple example, you should implement the logic in the checkAuthFailure method
            // based on the request received
            return false;
        }
    }
}