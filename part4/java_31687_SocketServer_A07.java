import java.io.*;
import java.net.*;

public class java_31687_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket that listens on port 8080
            server = new ServerSocket(8080);
            System.out.println("Server is running and waiting for a client to connect...");

            // Accept a client
            socket = server.accept();
            System.out.println("Client connected");

            // Create a DataInputStream and DataOutputStream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send a response to the client
            String response = "Server received your message: " + message;
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connections
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}