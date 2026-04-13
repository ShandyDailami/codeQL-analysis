import java.io.*;
import java.net.*;
import java.util.*;

public class java_25189_SocketServer_A07 {

    private static List<String> authorizedUsers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // Initialize server socket
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        // Main loop to accept client connections
        while (true) {
            Socket socket = server.accept();

            // Handle client connection
            System.out.println("New client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username from client
            String username = in.readUTF();
            System.out.println("Username: " + username);

            // Check if username is in authorized users list
            if (authorizedUsers.contains(username)) {
                System.out.println("Authorized user, authenticating...");
                out.writeUTF("Successfully authenticated");
            } else {
                System.out.println("Unauthorized user, authenticating as failed");
                out.writeUTF("Authentication failed");
            }

            // Close connections
            socket.close();
        }
    }
}