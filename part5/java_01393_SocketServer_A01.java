import java.net.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_01393_SocketServer_A01 {
    private static final String SHARED_SECRET = "SharedSecretKey";
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Generate a key for encryption/decryption
            Key key = new SecretKeySpec(SHARED_SECRET.getBytes(), ALGORITHM);

            // Get the encrypted message from the client
            byte[] encryptedMessage = in.readBytes(clientSocket.getSoTimeout());

            // Decrypt the message
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

            // Send the decrypted message back to the client
            out.writeBytes(decryptedMessage);

            clientSocket.close();
        }
    }
}