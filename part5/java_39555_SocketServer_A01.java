import java.net.*;
import java.io.*;

public class java_39555_SocketServer_A01 {

    private static final int PORT = 1234;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();
        System.out.println("A client is connected");

        // Get input and output streams
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Read the message from the client
        String message = in.readUTF();
        System.out.println("Received: " + message);

        // Send a response back to the client
        String response = "Hello, client!";
        out.writeUTF(response);
        System.out.println("Sent: " + response);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}