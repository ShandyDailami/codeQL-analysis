import java.io.*;
import java.net.*;

public class java_19987_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket at port 1234
            ServerSocket serverSocket = new ServerSocket(1234);

            // Listen for incoming connections
            System.out.println("Waiting for a client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Listen for client messages
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}