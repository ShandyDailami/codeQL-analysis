import java.io.*;
import java.net.*;

public class java_33622_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444, 10, true);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Encrypt the data
            String message = in.readUTF();
            String encryptedMessage = encrypt(message);

            // Send encrypted message
            out.writeUTF(encryptedMessage);
            out.flush();
       
            socket.close();
        }
    }

    public static String encrypt(String message) {
        // Simple encryption for demonstration purposes
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage.append((char) (message.charAt(i) + 1));
        }
        return encryptedMessage.toString();
    }
}