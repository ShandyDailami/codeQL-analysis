import java.io.*;
import java.net.*;
import java.util.*;

public class java_12424_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String USER_PASSWORD_SALT = "SomeRandomString";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientInput = input.readUTF();
            String[] clientInfo = clientInput.split("-");

            if (isValidUser(clientInfo[0], clientInfo[1])) {
                System.out.println("User is valid, sending message to client...");
                output.writeUTF("Hello, Client!");
            } else {
                System.out.println("User is not valid, sending auth failure...");
                output.writeUTF("AUTH_FAILURE");
            }

            output.close();
            socket.close();
        }
    }

    private static boolean isValidUser(String username, String password) {
        return username.equals(validUsers.get(hash(password + USER_PASSWORD_SALT)));
    }

    private static int hash(String s) {
        int hash = 7;
        for (char c : s.toCharArray()) {
            hash = 31 * hash + c;
        }
        return hash;
    }
}