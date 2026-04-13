import java.io.*;
import java.net.*;

public class java_30820_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // First, check if the client is authenticated
            String username = in.readUTF();
            String password = in.readUTF();
            if (!authenticate(username, password)) {
                out.writeUTF("Authentication failed");
                out.flush();
                socket.close();
                continue;
            }

            // If authentication successful, send a greeting message
            out.writeUTF("Hello, client");
            out.flush();
        }
    }

    private static boolean authenticate(String username, String password) {
        // Here, you should implement your authentication logic.
        // For example, you can check if the username and password match a known one.
        // In a real application, you should hash the password and compare the hash with a stored hash.

        // For the sake of simplicity, we will just return true if the username is "admin" and the password is "password",
        // which is a valid credentials for this example.
        return username.equals("admin") && password.equals("password");
    }
}