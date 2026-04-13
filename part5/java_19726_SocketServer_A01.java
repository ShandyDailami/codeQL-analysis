import java.io.*;
import java.net.*;

public class java_19726_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            // Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create a input stream from the socket
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // Read the request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Send a response back to the client
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF("Hello, client, your request was: " + request);

            // Close the connections
            clientSocket.close();
       
        }
    }
}