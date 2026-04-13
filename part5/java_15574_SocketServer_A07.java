import java.io.*;
import java.net.*;
import java.util.*;

public class java_15574_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started on port 6666");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (usernameMatchesPassword(clientUsername, clientPassword)) {
                out.writeUTF("Connection established");
                out.writeUTF("You can now send messages to the client");
            } else {
                out.writeUTF("Wrong username or password");
            }

            out.close();
            socket.close();
        }
    }

    private static boolean usernameMatchesPassword(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}