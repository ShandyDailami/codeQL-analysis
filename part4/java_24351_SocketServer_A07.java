import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_24351_SocketServer_A07 {

    private static Map<String, String> userMap = new HashMap<>();
    private static boolean authenticationFailed = false;

    static {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        // you can add more users here
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);

        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // Authenticate the user
            if (!authenticate(username, password)) {
                // Authentication failed.
                authenticationFailed = true;
                out.writeUTF("Authentication failed");
                out.flush();
            } else {
                out.writeUTF("Authentication successful");
                out.flush();
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return userMap.containsKey(username) && userMap.get(username).equals(password);
    }
}