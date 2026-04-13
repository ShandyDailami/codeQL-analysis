import java.io.*;
import java.net.*;
import java.util.*;

public class java_22268_SocketServer_A01 {

    // List of valid users
    private static List<String> validUsers = Arrays.asList("admin", "user1", "user2");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authenticate the client
            String clientName = in.readUTF();
            String password = in.readUTF();

            if (authenticate(clientName, password)) {
                out.writeUTF("Authentication successful");
                out.writeUTF("Welcome, " + clientName);
            } else {
                out.writeUTF("Authentication failed");
           
            }
            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return validUsers.contains(username) && username.equals(password);
    }
}