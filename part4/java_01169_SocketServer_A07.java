import java.io.*;
import java.net.*;
import java.util.*;

public class java_01169_SocketServer_A07 {

    // Define a list of valid users
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            // Create a server socket and listen for connections on port 12345
            server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            // Wait for client to connect
            socket = server.accept();

            // Get input and output streams from the socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the user's name from the client
            String userName = in.readUTF();

            // Check if the user is valid
            if (isUserValid(userName)) {
                // User is valid, proceed with authentication
                out.writeUTF("Connection established");
            } else {
                // User is not valid, close the connection
                out.writeUTF("Authentication failed");
                socket.close();
            }

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to check if the user is valid
    private static boolean isUserValid(String userName) {
        // Check if the user is in the list of valid users
        return validUsers.contains(userName);
    }
}