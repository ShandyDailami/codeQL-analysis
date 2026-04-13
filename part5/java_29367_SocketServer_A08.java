import java.io.*;
import java.net.*;

public class java_29367_SocketServer_A08 {

    // Main method
    public static void main(String args[]) {
        Socket socket = null;
        ServerSocket server = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            // Setup server socket
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            // Wait for client to connect
            socket = server.accept();
            System.out.println("Client connected");

            // Setup input and output streams
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Handle client request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Respond to client
            String response = "Hello, client";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close streams
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}