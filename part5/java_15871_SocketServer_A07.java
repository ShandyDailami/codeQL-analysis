import java.io.*;
import java.net.*;

public class java_15871_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen on a port
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            while (true) {
                // Wait for a client to connect
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Send a welcome message
                dos.writeUTF("Welcome to the server!");

                // Handle client messages
                while (true) {
                    String message = dis.readUTF();
                    System.out.println("Received message from client: " + message);

                    // Check for special commands
                    if (message.equals("/exit")) {
                        dos.writeUTF("Exiting the server...");
                        break;
                    }

                    // Generate a response
                    String response = "Hello, client, your message was: " + message;
                    dos.writeUTF(response);
               
                    // Close the connection
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}