import java.io.*;
import java.net.*;
import java.util.*;

public class java_37975_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String[] validPasswords = {"password1", "password2", "password3"};

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();

            // Create streams for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username and password from client
            String clientUsername = in.readLine();
            String clientPassword = in.readLine();

            // Check if the client is valid
            if (isValid(clientUsername, clientPassword)) {
                out.writeBytes("Authentication successful\n");
            } else {
                out.writeBytes("Authentication failed\n");
                socket.close();
                continue;
            }

            // Continue with the rest of the process
            out.writeBytes("Thank you for connecting\n");
            socket.close();
        }
    }

    private static boolean isValid(String username, String password) {
        if (validUsers.contains(username) && validPasswords[0].equals(password)) {
            return true;
        }
        return false;
    }
}