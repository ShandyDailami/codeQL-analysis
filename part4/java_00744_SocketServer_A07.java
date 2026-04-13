import java.io.*;
import java.net.*;
import java.util.*;

public class java_00744_SocketServer_A07 {
    private static final String AUTH_FAILURE_ERROR = "A07_AuthFailure";

    public static void main(String[] args) {
        Socket serverSocket = null;
        ServerSocket server = null;

        try {
            // Create the server socket
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            // Wait for a client to connect
            serverSocket = server.accept();
            System.out.println("Client has connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(serverSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());

            // Read the client's request
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Check if the request is authenticated
            if (isAuthenticated(request)) {
                out.writeUTF("Success");
            } else {
                out.writeUTF(AUTH_FAILURE_ERROR);
            }

            // Close the connections
            serverSocket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAuthenticated(String request) {
        // Implement the authentication logic here
        // For simplicity, we will return true if the request is "auth", false otherwise
        return "auth".equals(request);
    }
}