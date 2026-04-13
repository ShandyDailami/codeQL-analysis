import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_33292_SessionManager_A08 {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        try {
            String message = "Hello, World!";
            String secretKeyStr = "12345678abcdefgh"; // This should be a real secret key

            Key secretKey = createSecretKey(secretKeyStr);

            byte[] encryptedMessage = encrypt(message.getBytes(), secretKey);
            byte[] decryptedMessage = decrypt(encryptedMessage, secretKey);

            System.out.println("Original Message: " + new String(message.getBytes()));
            System.out.println("Decrypted Message: " + new String(decryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Key createSecretKey(String key) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // For AES, the key length must be 128, 192, or 256 bits
        SecretKey secretKey = keyGenerator.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    private static byte[] encrypt(byte[] message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(message);
    }

    private static byte[] decrypt(byte[] encryptedMessage, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedMessage);
    }
}