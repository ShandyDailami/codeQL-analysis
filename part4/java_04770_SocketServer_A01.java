import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04770_SocketServer_A01 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            // Use a Future to handle the request and response
            Future<String> futureResponse = handleRequest(clientSocket);

            // Send the response to the client
            sendResponse(clientSocket, futureResponse.get());
        }
    }

    private static Future<String> handleRequest(Socket clientSocket) {
        return executor.submit(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Simulate a security-sensitive operation
                if ("DDoS".equals(request)) {
                    throw new RuntimeException("DoS attack detected");
                }

                return "Hello, client!";
            } catch (IOException | RuntimeException e) {
                return e.getMessage();
            }
        });
    }

    private static void sendResponse(Socket clientSocket, String response) {
        try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            writer.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}