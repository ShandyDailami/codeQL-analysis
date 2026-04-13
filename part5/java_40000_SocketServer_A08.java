import java.io.*;
import java.net.*;

public class java_40000_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listening on port 8080
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept(); // Waiting for a client to connect
            System.out.println("A new client has connected...");

            // Here we use InputStreamReader and BufferedReader to read the request from the client
            // Then we use OutputStreamWriter to send the response back to the client
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                // Assume the client sends a message
                String message = reader.readLine();

                // If the message is not a valid request, we send an error response
                if (!isValidRequest(message)) {
                    writer.println("ERROR: Invalid request");
                } else {
                    // Otherwise, we send a successful response
                    writer.println("SUCCESS: " + message);
                }
            }

            socket.close();
        }
    }

    private static boolean isValidRequest(String request) {
        // This is a placeholder for a real-world implementation of a request validation function
        // In a real-world scenario, you would need to implement a more sophisticated method to ensure that the request is valid
        // This is a simple example and may not cover all cases
        return request != null && !request.isEmpty();
    }
}