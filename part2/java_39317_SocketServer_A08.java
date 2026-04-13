import java.io.*;
import java.net.*;

public class java_39317_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            // Accept a client connection
            Socket client = server.accept();
            System.out.println("Accepted client connection from: " + client.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Process the message (This is a placeholder, do not use this in real-world applications)
            String processedMessage = processMessage(message);

            // Send the processed message back to the client
            out.writeUTF(processedMessage);
            out.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is a placeholder for processing the message
    private static String processMessage(String message) {
        // Simulate a security-sensitive operation
        // In a real-world scenario, this would be replaced with actual security operations
        // We're just checking if the message is "secret"
        if ("secret".equals(message)) {
            return "Access granted!";
        } else {
            return "Access denied!";
        }
    }
}