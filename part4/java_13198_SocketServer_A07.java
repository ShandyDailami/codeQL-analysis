import java.io.*;
import java.net.*;

public class java_13198_SocketServer_A07 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 1: Accept client's username
            String username = in.readUTF();
            System.out.println("Username: " + username);

            // Step 2: Check if the username is valid (This is a simple check and might not be secure)
            if (username.equals("admin")) {
                out.writeUTF("Valid username");
            } else {
                out.writeUTF("Invalid username");
                continue;
            }

            // Step 3: Send encrypted password
            out.writeUTF("Password sent to client, encrypted");

            // Step 4: Close the connection
            out.close();
            socket.close();
        }
    }
}