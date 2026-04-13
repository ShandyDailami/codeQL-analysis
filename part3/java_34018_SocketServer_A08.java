import java.io.*;
import java.net.*;

public class java_34018_SocketServer_A08 {
    private static final String REMOTE_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started. Listening on port " + SERVER_PORT);

        // Accept a client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

        // Create input and output streams
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Send a welcome message
        out.writeUTF("Welcome to the secure server!");

        // Receive a message from the client and send a response
        String message = in.readUTF();
        System.out.println("Received from client: " + message);
        out.writeUTF("Server received your message: " + message);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}