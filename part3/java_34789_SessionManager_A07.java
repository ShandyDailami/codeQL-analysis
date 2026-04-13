import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class java_34789_SessionManager_A07 {
    // Key length for AES
    private static final int KEY_LENGTH = 16;
    // Cipher for AES
    private Cipher cipher;

    // Generate and return a secret key
    private SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_LENGTH);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }

    // Encrypt a message
    public String encryptMessage(String message) throws Exception {
        SecretKey secretKey = generateSecretKey();
        cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    // Decrypt a message
    public String decryptMessage(String encryptedMessage) throws Exception {
        byte[] encryptedMsgByte = Base64.getDecoder().decode(encryptedMessage);
        byte[] decryptedMsgByte = cipher.doFinal(encryptedMsgByte);
        return new String(decryptedMsgByte);
    }

    public static void main(String[] args) throws Exception {
        SessionManager sessionManager = new SessionManager();
        String message = "This is a secure message.";
        String encryptedMessage = sessionManager.encryptMessage(message);
        String decryptedMessage = sessionManager.decryptMessage(encryptedMessage);
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}