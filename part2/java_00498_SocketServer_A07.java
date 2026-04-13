import java.io.*;
import java.net.*;
import java.util.*;

public class java_00498_SocketServer_A07 {
    private static final int PORT = 9876;
    private static Set<String> authenticatedUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for clients...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            try {
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Authenticate the user
                String user = in.readUTF();
                if (authenticateUser(user)) {
                    out.writeUTF("Welcome, " + user + "!");
                } else {
                    out.writeUTF("Authentication failed");
                    client.close();
                }
            } catch (IOException e) {
                System.out.println("Error handling client " + client.getRemoteSocketAddress());
                client.close();
            }
        }
    }

    private static boolean authenticateUser(String user) {
        // Simulated authentication process
        // Replace this with your actual authentication logic
        return authenticatedUsers.contains(user);
    }
}