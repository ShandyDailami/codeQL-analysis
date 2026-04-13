import java.io.*;
import java.net.*;
import java.util.*;

public class java_32468_SocketServer_A07 {

    private static List<String> authorizedUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started, waiting for clients...");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authentication
            String username = in.readUTF();
            if (!isUserAuthorized(username)) {
                out.writeUTF("Authentication failed");
                out.flush();
            } else {
                out.writeUTF("Authentication successful");
                out.flush();
            }

            socket.close();
        }
    }

    private static boolean isUserAuthorized(String username) {
        return authorizedUsers.contains(username);
    }
}