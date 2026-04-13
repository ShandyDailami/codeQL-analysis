import java.io.*;
import java.net.*;
import java.util.*;

public class java_34875_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin"; // predefined user
    private static final String AUTHENTICATED_PASSWORD = "password"; // predefined password

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Read the username and password from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String username = in.readUTF();
            String password = in.readUTF();

            // Check if the username and password match
            if (username.equals(AUTHENTICATED_USER) && password.equals(AUTHENTICATED_PASSWORD)) {
                System.out.println("Authentication successful");

                // Send a message to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, client!");
            } else {
                System.out.println("Authentication failed");
            }

            // Close the connection
            socket.close();
        }
    }
}