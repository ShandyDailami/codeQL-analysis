import java.io.*;
import java.net.*;

public class java_29953_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Wait for a connection
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF(); // Read a message from the client
            System.out.println("Received message: " + message);

            out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + "\n"); // Send a response back to the client
            out.flush();

            clientSocket.close(); // Close the connection
        }
    }
}