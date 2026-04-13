import java.net.*;
import java.io.*;
import java.security.MessageDigest;

public class java_16053_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            if (authenticateUser(clientMessage)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticateUser(String clientMessage) throws IOException {
        // Use MD5 to hash the user password
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(clientMessage.getBytes());

        // Compare the hash with the stored hash
        // For simplicity, we'll just compare the hashes directly
        // This is not secure against hash collision attacks
        return hash.equals(clientMessage.getBytes());
    }
}