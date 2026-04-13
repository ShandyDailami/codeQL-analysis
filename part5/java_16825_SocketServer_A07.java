import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class java_16825_SocketServer_A07 {
    private static final String KEY = "a secret kick ass key";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Receive message
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            String message = in.readUTF();

            // Decrypt message
            byte[] encryptedMessage = Base64.getDecoder().decode(message);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), "AES"));
            byte[] decryptedMessage = cipher.doFinal(encryptedMessage);

            String decrypted = new String(decryptedMessage, StandardCharsets.UTF_8);
            System.out.println("Received: " + decrypted);

            // Send response
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            String response = "Server received your message";
            String encrypted = Base64.getEncoder().encodeToString(response.getBytes(StandardCharsets.UTF_8));
            out.writeUTF(encrypted);

            System.out.println("Sent: " + response);
            clientSocket.close();
        }
    }
}