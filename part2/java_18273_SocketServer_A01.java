import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_18273_SocketServer_A01 {
    private static final String KEY = "a secret key";
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the encrypted message from the client
            byte[] encryptedMessage = in.readBytes(1024);

            // Decrypt the message
            SecretKey key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

            // Send the decrypted message to the client
            out.write("Server received: ".getBytes());
            out.write(decryptedMessage);
            out.write("\n".getBytes());
            out.flush();
        }
    }
}