import java.io.*;
import java.net.*;

public class java_05248_SocketServer_A08 {
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client on port " + PORT + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send the server's public key to the client
            out.writeUTF("My public key: " + socket.getInetAddress().getHostAddress() + "\n\n");

            while (true) {
                // Receive the client's encrypted message
                String encryptedMessage = in.readUTF();
                System.out.println("Received: " + encryptedMessage);

                // Decrypt the message using the client's private key
                // This is a simplified example, in a real application you'd likely use a cryptographic library
                String decryptedMessage = decryptMessage(encryptedMessage, socket.getLocalPort());
                System.out.println("Decrypted: " + decryptedMessage);

                // Send the decrypted message back to the client
                out.writeUTF("Message received, decrypted: " + decryptedMessage + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decryptMessage(String encryptedMessage, int localPort) {
        // This is a placeholder for a real implementation. In a real application, you'd likely use a library or API
        // that supports decrypting messages, using the client's private key.
        // For simplicity, we'll just return the original message.
        return encryptedMessage;
    }
}