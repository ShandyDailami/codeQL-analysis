import java.io.*;
import java.net.*;

public class java_18644_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Server listens on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // Accept a client connection
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the client's message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Respond to the client
            out.writeUTF("Hello, client!");

            // Close the connection
            socket.close();
        }
    }
}