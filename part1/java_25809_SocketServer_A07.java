import java.io.*;
import java.net.*;
import java.util.*;

public class java_25809_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed!";

    private static List<String> authorizedUsers = Arrays.asList("User1", "User2", "User3");

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected");

                // Perform authentication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                if (isUserAuthorized(username)) {
                    out.writeUTF(AUTHENTICATION_SUCCESS);
                    System.out.println("User " + username + " successfully authenticated");
                } else {
                    out.writeUTF(AUTHENTICATION_FAILURE);
                    System.out.println("Authentication failed for user " + username);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUserAuthorized(String username) {
        return authorizedUsers.contains(username);
    }
}