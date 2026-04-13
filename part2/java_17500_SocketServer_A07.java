import java.io.*;
import java.net.*;
import java.util.*;

public class java_17500_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Authentication Successful";
    private static final String AUTH_FAILURE = "Authentication Failed";
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                if (authenticate(username)) {
                    out.writeUTF(AUTH_SUCCESS);
                } else {
                    out.writeUTF(AUTH_FAILURE);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username) {
        return validUsers.contains(username);
    }
}