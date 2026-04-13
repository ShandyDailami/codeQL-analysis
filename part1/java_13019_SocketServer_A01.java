import java.io.*;
import java.net.*;

public class java_13019_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen for client connections
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Handle client communication
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + "!");

            // Close the connection
            clientSocket.close();
        }
    }
}