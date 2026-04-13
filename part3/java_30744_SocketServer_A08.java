import java.io.*;
import java.net.*;

public class java_30744_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to a port
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Client has connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send the message to the client
            String response = "Hello, Client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}