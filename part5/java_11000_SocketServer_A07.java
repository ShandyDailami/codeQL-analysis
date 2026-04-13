import java.io.*;
import java.net.*;
import java.util.*;

public class java_11000_SocketServer_A07 {

    // Define a list of users and their passwords
    private static List<User> users = new ArrayList<>();

    // Define a User class
    public static class User {
        String username;
        String password;

        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Main method
    public static void main(String[] args) throws Exception {
        // Create a socket
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("Client connected.");

            // Get the input and output streams
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the username and password from the client
            String username = in.readUTF();
            String password = in.readUTF();

            // Authenticate the user
            if (authenticate(username, password)) {
                out.writeUTF("Authentication successful.");
            } else {
                out.writeUTF("Authentication failed.");
            }

            // Close the connection
            client.close();
        }
    }

    // Method to authenticate a user
    private static boolean authenticate(String username, String password) {
        // In a real application, you would probably want to hash the passwords and compare them
        // against the hashed passwords in your database
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
}