import java.io.*;
import java.net.*;
import java.util.*;

public class java_15078_SocketServer_A08 {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    private static final String ENCRYPTION_KEY = "encryption_key";

    private static String readMessage(DataInputStream in) throws IOException {
        byte[] bytes = new byte[1000];
        in.readFully(bytes);
        return new String(bytes);
    }

    private static void writeMessage(DataOutputStream out, String message) throws IOException {
        out.writeBytes(message);
    }

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = readMessage(in);

            // Encrypt the message
            byte[] encryptedMessage = encryptMessage(message);

            // Send the encrypted message
            writeMessage(out, encryptedMessage);

            // Close the socket
            socket.close();
        }
    }

    private static byte[] encryptMessage(String message) {
        // Implement encryption here
        // This is a simple example, not secure for real-world applications
        // You would likely use a standard library for encryption
        byte[] encrypted = message.getBytes();
        return encrypted;
    }
}