import java.io.*;
import java.net.*;

public class java_18718_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            while (true) {
                // Accept a new client
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Handle client input
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Received: " + message);

                    // Check for injection attempts
                    if (message.contains("DROP TABLE")) {
                        System.out.println("Attempting injection!");
                        // Simulate injection
                        message = message.replace("DROP TABLE", "CREATE TABLE");
                        System.out.println("Injection successful!");
                    }

                    // Send back to client
                    output.writeUTF("Received: " + message);
                    output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}