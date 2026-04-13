import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_37587_SessionManager_A08 {
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "12345678abcdefgh".getBytes(StandardCharsets.UTF_8);

    public static String encrypt(String value) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(keyValue, ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String value) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(keyValue, ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(value));
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String value = "This is a test";
        String encrypted = encrypt(value);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}