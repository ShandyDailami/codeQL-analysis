import java.net.*;
import java.io.*;

public class java_31196_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket on port 8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            // Wait for client connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create InputStream and OutputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send message to client
            out.writeUTF("Message received");
            out.flush();

            // Close connections
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}