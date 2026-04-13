import java.io.*;
import java.net.*;
import java.util.*;

public class java_02292_SocketServer_A07 {
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpassword";

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);

        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();

            // Read the request
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Parse the request
            String[] parts = request.split(" ");
            String username = parts[1];
            String password = parts[2];

            // Authenticate
            if (authenticate(username, password)) {
                // Authentication successful
                System.out.println("Authentication successful");
            } else {
                // Authentication failed
                System.out.println("Authentication failed");
           
                // Close the connection
                socket.close();
            }
        }
    }
}