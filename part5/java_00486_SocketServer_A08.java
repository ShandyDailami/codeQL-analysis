import java.io.*;
import java.net.*;
import java.util.*;

public class java_00486_SocketServer_A08 {
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket and bind it to the port
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read and process the request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Perform security-sensitive operations
            // For example, checking the integrity of the request
            if (checkIntegrity(request)) {
                System.out.println("Request is valid, processing...");
                // Process the request here
            } else {
                System.out.println("Request is not valid, dropping connection...");
                socket.close();
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket if it's still open
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method for security-sensitive operations
    private static boolean checkIntegrity(String request) {
        // Insert your security-sensitive code here
        // For example, use a hash function to check the integrity of the request
        // This is a simple example and may not be suitable for a real-world application
        return true;
    }
}