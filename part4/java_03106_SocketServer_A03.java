import java.io.*;
import java.net.*;
import java.util.*;

public class java_03106_SocketServer_A03 {
    private static List<String> usernames = Arrays.asList("admin", "user1", "user2", "user3");
    private static List<String> passwords = Arrays.asList("password", "password123", "user3", "user2");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // listen on port 1234
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientIP = socket.getInetAddress().getHostAddress();
            int clientPort = socket.getPort();

            // send client info to client
            out.writeUTF("Client IP: " + clientIP + ", Port: " + clientPort);
            out.flush();

            // receive username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // check if username and password match
            if (checkCredentials(username, password)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            out.flush();
            socket.close();
        }
    }

    private static boolean checkCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                return true;
            }
        }

        return false;
    }
}