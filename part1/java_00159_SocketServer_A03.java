import java.io.*;
import java.net.*;

public class java_00159_SocketServer_A03 {

    public static void main(String[] args) {

        // Create a socket and bind it to a port
        try (ServerSocket server = new ServerSocket(5000)) {

            System.out.println("Server started, waiting for connections...");

            // Accept incoming connections
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Get input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            writer.writeUTF("Welcome to the chat server!");

            // Start receiving and sending messages
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Broadcast the message to all clients
                writer.writeUTF("Server: " + message);
            }

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}