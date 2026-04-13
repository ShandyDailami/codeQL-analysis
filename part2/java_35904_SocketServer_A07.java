import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class java_35904_SocketServer_A07 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/NoPadding";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Generate random key
            Key key = KeyGenerator.getInstance("AES").generateKey();

            // Encrypt the key
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedKey = cipher.doFinal(key.getEncoded());

            // Send the encrypted key to the client
            out.writeInt(encryptedKey.length);
            out.write(encryptedKey);

            // Start receiving data
            byte[] buffer = new byte[1024];
            int bytesCount = in.read(buffer);
            if (bytesCount < 0) {
                System.out.println("Client disconnected...");
                socket.close();
            } else {
                // Decrypt the data
                Cipher decipher = Cipher.getInstance(TRANSFORMATION);
                decipher.init(Cipher.DECRYPT_MODE, key);
                byte[] decryptedData = decipher.doFinal(buffer, 0, bytesCount);

                // Print the decrypted data
                System.out.println("Received data: " + new String(decryptedData));
            }

            socket.close();
        }
    }
}