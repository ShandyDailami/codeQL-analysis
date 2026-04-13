import java.io.*;
import java.net.*;

public class java_00756_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        // Accept client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Create input and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Send a welcome message
        out.writeUTF("Welcome to the server! You are connected to port 12345");

        // Receive client's message
        String message = in.readUTF();
        System.out.println("Client says: " + message);

        // Close connection
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

        System.out.println("Connection closed");

    }
}