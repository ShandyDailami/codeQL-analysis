import java.io.*;
import java.net.*;

public class java_31994_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234; // Change this to a port number you wish to use
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket on the specified port
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Wait for a client to connect to the server
            socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Create a PrintWriter for sending messages to the client
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            outToClient.writeUTF("Hello, client!");

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}