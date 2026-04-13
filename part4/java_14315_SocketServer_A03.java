import java.io.*;
import java.net.*;
import java.util.*;

public class java_14315_SocketServer_A03 {
    private static final String PASSWORD = "password"; // This should be stored securely
    private static final String USERNAME = "username"; // Also, store securely

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the username and password from the client
            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            // Check if the username and password match
            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                System.out.println("Authentication successful.");

                // Send a welcome message to the client
                out.writeUTF("Welcome, client!");
            } else {
                System.out.println("Authentication failed.");
                out.writeUTF("Authentication failed.");
            }

            // Close the streams
            out.close();
            in.close();

            socket.close();
        }
    }
}