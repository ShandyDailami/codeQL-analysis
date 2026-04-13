import java.io.*;
import java.net.*;
import java.util.*;

public class java_04880_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private static List<String> authorizedUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                String[] messageParts = clientMessage.split("\\s+");

                if (messageParts.length != 2) {
                    out.writeUTF("Invalid message format, expecting username and password");
                    out.flush();
                    continue;
                }

                String username = messageParts[0];
                String password = messageParts[1];

                if (isAuthenticated(username, password)) {
                    out.writeUTF("Authenticated successfully");
                } else {
                    out.writeUTF(AUTH_FAILURE);
                }

                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAuthenticated(String username, String password) {
        return authorizedUsers.contains(username) && password.equals("password");
    }
}