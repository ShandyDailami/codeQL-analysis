import java.io.*;
import java.net.*;

public class java_16557_SocketServer_A07 {
    // hardcoded credentials for testing
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Authentication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                System.out.println("Authentication successful");

                // Continue with data exchange if authentication successful
                out.writeUTF("Hello, client!");
            } else {
                System.out.println("Authentication failed");
                out.writeUTF("Failed to authenticate");
            }

            out.close();
            socket.close();
        }
    }
}