import java.io.*;
import java.net.*;

public class java_36935_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Server port
        int port = 12345;

        // Create a server socket and listen for incoming connections
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for a client to connect...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create an input stream to read from the client
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // Create an output stream to write to the client
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the client's message
            String message = in.readUTF();

            // Send the client's message back to them
            out.writeUTF("Message from server: " + message);

            // Close the connection
            clientSocket.close();
       
            // End of connection
            System.out.println("Connection closed");
        }
    }
}