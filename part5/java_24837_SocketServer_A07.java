import java.io.*;
import java.net.*;
import java.util.*;

public class java_24837_SocketServer_A07 {

    // This is a very simple and basic form of authentication. In a real application,
    // you would likely use a more secure method such as hashing and salting passwords.
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "password");
        users.put("user", "password");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read username and password from client
            String username = in.readUTF();
            String password = in.readUTF();

            // Check if username and password are valid
            if ("admin".equals(username) && "password".equals(password)) {
                out.writeUTF("Authenticated as admin");
            } else if ("user".equals(username) && "password".equals(password)) {
                out.writeUTF("Authenticated as user");
            } else {
                out.writeUTF("Authentication failed");
            }

            out.close();
            client.close();
        }
    }
}