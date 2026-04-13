import java.io.*;
import java.net.*;
import java.util.*;

public class java_31114_SocketServer_A07 {
    private static final int PORT = 5000;
    private static final String AUTH_USER = "user";
    private static final String AUTH_PASS = "pass";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server started. Listening for client on port " + PORT);

        while (true) {
            Socket client = server.accept();

            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String clientInput = in.readUTF();
            String[] credentials = clientInput.split(":");

            if (validateClient(credentials[0], credentials[1])) {
                out.writeUTF("Connection successful. Welcome!");
            } else {
                out.writeUTF("Failed to authenticate. Please try again.");
            }

            client.close();
        }
    }

    private static boolean validateClient(String user, String pass) {
        return user.equals(AUTH_USER) && pass.equals(AUTH_PASS);
    }
}