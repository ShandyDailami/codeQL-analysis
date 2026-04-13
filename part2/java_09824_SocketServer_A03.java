import java.io.*;
import java.net.*;

public class java_09824_SocketServer_A03 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        try {
            // Create a server socket and listen on a specific port
            server = new ServerSocket(3456);
            System.out.println("Server is listening on port: 3456");

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Client connected!");

            // Create an input and output stream from the socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Reply to the client
            String response = "Server Received your message!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}