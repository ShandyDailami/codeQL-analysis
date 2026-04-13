import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_02946_SocketServer_A07 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (authenticate(username, password)) {
                out.writeUTF("Welcome, " + username + ". You are now authenticated.");
            } else {
                out.writeUTF("Access denied for " + username);
            }

            client.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return credentials.get(username).equals(password);
    }
}