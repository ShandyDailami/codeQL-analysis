import java.io.*;
import java.net.*;

public class java_10595_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444); // default port
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected");

            // Create input and output stream for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = in.readUTF();

            // Check if client disconnected
            if (message.equals("quit")) {
                System.out.println("Client disconnected");
                break;
            }

            // Check if client is trying to brute force the server
            if (message.contains("attempt")) {
                out.writeUTF("Sorry, but I'm not able to handle brute force attacks");
                continue;
            }

            // Check if client is trying to read sensitive information
            if (message.contains("password")) {
                out.writeUTF("Sorry, but I'm not able to read sensitive information");
                continue;
            }

            // Send back the same message to client
            out.writeUTF(message);
        }

        // Close the server socket
        server.close();
    }
}