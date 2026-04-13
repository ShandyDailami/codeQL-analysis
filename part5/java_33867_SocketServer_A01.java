import java.io.*;
import java.net.*;

public class java_33867_SocketServer_A01 {

    public static void main(String[] args) {

        // Create a socket and bind it to a port
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            // Start accepting client connections
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected!");

                    // Handle client connection
                    handleClient(clientSocket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate a security violation by echoing the message back to the client
                writer.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}