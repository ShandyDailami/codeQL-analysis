import java.io.*;
import java.net.*;

public class java_23153_SocketServer_A07 {
    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the username
            String username = input.readUTF();
            System.out.println("Received username: " + username);

            // Authenticate the username
            if (!authenticate(username)) {
                output.writeUTF("Authentication failed");
                output.flush();
                socket.close();
                continue;
            }

            // Send a welcome message
            output.writeUTF("Welcome, " + username + "!");
            output.flush();

            // Close the socket
            socket.close();
        }
    }

    private static boolean authenticate(String username) {
        // TODO: Implement authentication logic
        // For now, we'll just return true
        return true;
    }
}