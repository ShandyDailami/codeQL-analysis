import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_33161_SocketServer_A01 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            if (authenticate(clientMessage)) {
                out.writeUTF("Hello, World!");
            } else {
                out.writeUTF("Access denied.");
            }
            socket.close();
        }
    }

    private static boolean authenticate(String user) {
        String[] credentials = user.split(" ");
        if (credentials.length != 2) {
            return false;
        }

        String userToCheck = credentials[0];
        String passwordToCheck = credentials[1];

        if (!users.containsKey(userToCheck)) {
            System.out.println("Unknown user: " + userToCheck);
            return false;
        }

        if (!users.get(userToCheck).equals(passwordToCheck)) {
            System.out.println("Invalid password for user: " + userToCheck);
            return false;
        }

        return true;
    }
}