import java.io.*;
import java.net.*;

public class java_30463_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            // Create a server socket
            server = new ServerSocket(port);
            System.out.println("Waiting for client on port " + port);

            // Accept a connection
            socket = server.accept();
            System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

            // Create input and output streams
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            // Send a greeting message
            output.writeUTF("Welcome to the server!");

            // Receive a message from the client and echo it back
            String message = input.readUTF();
            System.out.println("Client says: " + message);
            output.writeUTF("Your message was: " + message);

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}