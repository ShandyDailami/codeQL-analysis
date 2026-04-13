import java.io.*;
import java.net.*;

public class java_29511_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read username from client
                String username = in.readUTF();
                System.out.println("Received username: " + username);

                // Authenticate user and send response
                if (authenticateUser(username)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateUser(String username) {
        // Here you would typically use a secure method to hash and compare the username and password
        // This is a very basic example and should not be used for real security applications
        return "admin".equals(username);
    }
}