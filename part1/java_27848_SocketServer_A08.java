import java.net.*;
import java.io.*;

public class java_27848_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        // Accept a client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected...");

        // Create input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Read from the client
        String message = input.readUTF();
        System.out.println("Client says: " + message);

        // Send a response
        String response = "Hello, client!";
        output.writeUTF(response);
        System.out.println("Server says: " + response);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}