import java.io.*;
import java.net.*;
import java.util.*;

public class java_21594_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started on port 6666");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (isValidUser(username, password)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
                socket.close();
                continue;
            }

            out.writeUTF("Hello, " + username + ". You are connected to the server.");

            String message = in.readUTF();
            System.out.println("Received message from " + username + ": " + message);

            out.writeUTF("Thank you for connecting. Goodbye!");
            socket.close();
        }
    }

    private static boolean isValidUser(String username, String password) {
        return validUsers.contains(username) && validUsers.contains(password);
    }
}