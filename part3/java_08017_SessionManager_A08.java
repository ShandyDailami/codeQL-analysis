import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class java_08017_SessionManager_A08 {
    private static final String PASSWORD = "password"; // Secret password
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512"; // Algorithm
    private static final int KEY_LENGTH = 512; // Key length
    private static final int ITERATIONS = 64000; // Iterations

    public String hashPassword(String password) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), PASSWORD.getBytes(), ITERATIONS, KEY_LENGTH));
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public String decrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void main(String[] args) throws Exception {
        SessionManager manager = new SessionManager();

        // Hashing password
        String hashedPassword = manager.hashPassword(PASSWORD);
        System.out.println("Hashed Password: " + hashedPassword);

        // Encrypting data
        String encryptedData = manager.encrypt("Hello World", hashedPassword);
        System.out.println("Encrypted Data: " + encryptedData);

        // Decrypting data
        String decryptedData = manager.decrypt(encryptedData, hashedPassword);
        System.out.println("Decrypted Data: " + decryptedData);
    }
}