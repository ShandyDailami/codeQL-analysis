import java.io.*;
import java.net.*;
import java.util.*;

public class java_19190_SocketServer_A08 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            // Create a ServerSocket on port 8080
            server = new ServerSocket(8080);
            System.out.println("Waiting for connection on port 8080...");

            // Accept a client connection
            socket = server.accept();
            System.out.println("Connected to client");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a string from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Encrypt the message
            String encryptedMessage = encrypt(message);

            // Send the encrypted message back to the client
            out.writeUTF(encryptedMessage);
            System.out.println("Sent encrypted message back to client");

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String message) {
        // This is a simple encryption algorithm that replaces each character with the
        // character 5 positions ahead in the alphabet
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                encryptedMessage.append((char) ((ch - 'a' + 5) % 26 + 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                encryptedMessage.append((char) ((ch - 'A' + 5) % 26 + 'A'));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    }
}