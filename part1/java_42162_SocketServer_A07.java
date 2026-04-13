import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_42162_SocketServer_A07 {
    private static HashMap<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg = in.readUTF();
                String clientUser = clientMsg.substring(0, clientMsg.indexOf(' '));
                String clientPass = clientMsg.substring(clientMsg.indexOf(' ') + 1);

                String serverMsg = authenticate(clientUser, clientPass);
                out.writeUTF(serverMsg);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String authenticate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return "Authentication successful for user: " + username;
        } else {
            return "Authentication failed";
        }
    }
}