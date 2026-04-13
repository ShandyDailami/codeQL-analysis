import java.net.*;
import java.io.*;
import java.util.*;

public class java_07409_SocketServer_A07 {

    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed!";

    private static List<String> authorizedUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started at port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                handleClient(socket);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username
            String username = in.readUTF();
            System.out.println("Username: " + username);

            // authenticate user
            if (isAuthenticated(username)) {
                out.writeUTF(AUTHENTICATION_SUCCESS);
            } else {
                out.writeUTF(AUTHENTICATION_FAILURE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAuthenticated(String username) {
        return authorizedUsers.contains(username);
    }
}