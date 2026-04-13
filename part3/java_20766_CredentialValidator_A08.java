import java.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_20766_CredentialValidator_A08 {

    public static void main(String[] args) throws Exception {
        String plainText = "This is a test message";
        System.out.println("Plain text: " + plainText);

        // Generate a Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // AES requires a 128 bit key
        SecretKey secretKey = keyGenerator.generateKey();

        // Encrypt the message
        byte[] encryptedMessage = encryptMessage(plainText, secretKey);
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));

        // Decrypt the message
        byte[] decryptedMessage = decryptMessage(encryptedMessage, secretKey);
        System.out.println("Decrypted message: " + new String(decryptedMessage));
    }

    private static byte[] encryptMessage(String message, SecretKey secretKey) throws Exception {
        byte[] keyBytes = secretKey.getEncoded();
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(messageBytes);
    }

    private static byte[] decryptMessage(byte[] encryptedMessage, SecretKey secretKey) throws Exception {
        byte[] keyBytes = secretKey.getEncoded();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedMessage);
    }
}