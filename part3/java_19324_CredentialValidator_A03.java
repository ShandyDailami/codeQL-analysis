import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_19324_CredentialValidator_A03 {
    private static final String SECRET = "my-super-secret-key"; // A secret key for demonstration
    private static final String SALT = "salt"; // A salt for demonstration

    public static SecretKey getKey() {
        return getKey(SALT);
    }

    public static SecretKey getKey(String salt) {
        SecretKeyFactory secretKeyFactory = null;
        SecretKey secretKey = null;

        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            PBEKeySpec keySpec = new PBEKeySpec(SECRET.toCharArray(), salt.getBytes(), 10000, 256);
            secretKey = secretKeyFactory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            throw new RuntimeException(e);
        }
        return secretKey;
    }

    public static String hashPassword(String password, String salt) {
        return Base64.getEncoder().encodeToString(getKey(salt).getEncoded() + ":" + getKey(salt).getAlgorithmName() + ":" + password);
    }

    public static boolean verifyPassword(String password, String hash) {
        return hashPassword(password, hash).equals(hash);
    }
}