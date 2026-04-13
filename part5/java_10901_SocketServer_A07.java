import java.io.*;
import java.net.*;
import java.util.*;

public class java_10901_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            if (clientMessage.startsWith("login")) {
                String[] parts = clientMessage.split(":");
                String username = parts[1];
                String password = parts[2];

                if (password.equals(PASSWORD)) {
                    out.writeUTF("Connection accepted");
                } else {
                    out.writeUTF("Connection denied");
                }
            } else {
                out.writeUTF("Unknown command");
            }

            out.flush();
            socket.close();
        }
    }
}