import java.io.*;
import java.net.*;
import java.util.*;

public class java_23425_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 1234;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);
            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Connected to " + client.getRemoteSocketAddress());
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());

                    String clientUsername = in.readUTF();
                    String clientPassword = in.readUTF();

                    if (authenticate(clientUsername, clientPassword)) {
                        out.writeUTF("Connection successful");
                    } else {
                        out.writeUTF("Invalid username or password");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}