import java.io.*;
import java.net.*;

public class java_02757_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 5000;

        // Create a server socket and listen for incoming connections
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Handle communication with the client
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Simulate a security-sensitive operation (e.g., integrity failure)
                // In a real-world application, you would likely use cryptographic techniques here
                if (clientMessage.equalsIgnoreCase("fail_integrity")) {
                    throw new RuntimeException("Integrity failure");
                }

                // Send a response back to the client
                out.println("Server: Message accepted");
            }

            // Clean up
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}