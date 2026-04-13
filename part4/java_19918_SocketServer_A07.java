import java.io.*;
import java.net.*;
import java.util.*;

public class java_19918_SocketServer_A07 {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String request = in.readUTF();
            String[] parts = request.split(" ");

            if (parts.length != 2 || !parts[0].equals("AUTH")) {
                System.out.println("Invalid request: " + request);
                out.writeUTF("ERROR\n");
                out.flush();
                continue;
            }

            String username = parts[1];
            String password = in.readUTF();

            if (!username.equals(CORRECT_USERNAME) || !password.equals(CORRECT_PASSWORD)) {
                System.out.println("Invalid credentials: " + username + ", " + password);
                out.writeUTF("ERROR\n");
                out.flush();
                continue;
            }

            System.out.println("Authorized: " + username);
            out.writeUTF("OK\n");
            out.flush();
        }
    }
}