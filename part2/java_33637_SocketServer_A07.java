import java.net.*;
import java.io.*;
import java.util.*;

public class java_33637_SocketServer_A07 {

    private static final String SERVER_SOFTWARE = "Java Socket Server";
    private static final int SERVER_PORT = 12345;
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PWD = "password";

    public static void main(String[] args) {
        try {
            // Create socket server
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Wait for client connection
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

                // Read username and password from client
                DataInputStream in = new DataInputStream(client.getInputStream());
                String username = in.readUTF();
                String password = in.readUTF();

                // Check if username and password match
                if (username.equals(AUTH_USER) && password.equals(AUTH_PWD)) {
                    System.out.println("Authentication successful");
                } else {
                    System.out.println("Authentication failed");
                    client.close();
                    continue;
                }

                // Send message to client
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Hello, client!");
                out.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}