import java.io.*;
import java.net.*;

public class java_25897_SocketServer_A07 {
    private static final int PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize the server socket
        server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            // Step 2: Accept a client socket
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Step 3: Handle client communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 4: Implement authentication
            String username = in.readUTF();
            String password = in.readUTF();

            if (isValidUser(username, password)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           
            // Step 5: Close the connection
            socket.close();
            }
        }
    }

    // Step 6: Implement the authentication logic
    private static boolean isValidUser(String username, String password) {
        // This is a placeholder. In a real-world application, you should use a secure method to hash and compare passwords.
        return username.equals("admin") && password.equals("password");
    }
}