import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_17686_SocketServer_A07 {
    private static final int PORT = 8080;
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String username = in.readUTF();
            String password = in.readUTF();

            if (authenticate(username, password)) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return credentials.get(username) != null && credentials.get(username).equals(password);
    }
}