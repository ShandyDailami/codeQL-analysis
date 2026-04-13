import java.io.*;
import java.net.*;
import java.util.*;

public class java_36116_SocketServer_A01 {
    private static List<String> usernames = Arrays.asList("John", "Mary", "Adam", "Steve");
    private static List<String> passwords = Arrays.asList("John", "Mary", "Adam", "Steve");

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create stream for reading and writing data
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read username and password
            String username = reader.readLine();
            String password = reader.readLine();

            // Check if the credentials are valid
            if (checkCredentials(username, password)) {
                writer.println("Access granted");
            } else {
                writer.println("Access denied");
            }

            // Close the connection
            socket.close();
        }
    }

    private static boolean checkCredentials(String username, String password) {
        int index = usernames.indexOf(username);

        // If username is not found or passwords do not match, return false
        if (index == -1 || !passwords.get(index).equals(password)) {
            return false;
        }

        return true;
    }
}