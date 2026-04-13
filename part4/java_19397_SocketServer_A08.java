import java.io.*;
import java.net.*;
import java.util.*;

public class java_19397_SocketServer_A08 {
    private static final String PASSWORD = "secure";
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);

        System.out.println("Server started on port 8189.");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();

            if (clientMsg.startsWith("register")) {
                String username = clientMsg.split(" ")[1];
                users.put(username, PASSWORD);
                out.writeUTF("Registered successfully.");
            } else if (clientMsg.startsWith("login")) {
                String username = clientMsg.split(" ")[1];
                String password = clientMsg.split(" ")[2];

                if (users.get(username).equals(password)) {
                    out.writeUTF("Logged in successfully.");
                } else {
                    out.writeUTF("Invalid username or password.");
                }
            } else {
                out.writeUTF("Unknown command.");
            }

            out.close();
            socket.close();
        }
    }
}