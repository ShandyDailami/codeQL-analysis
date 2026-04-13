import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_26658_CredentialValidator_A01 {
    private static final String SECRET = "my-secret-key"; // This should be kept secret

    public static boolean validate(String username, String password) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey secretKey = secretKeyFactory.generateSecret(new PBEKeySpec(SECRET.toCharArray(), "salt".getBytes(), 256, 256));

            byte[] check = secretKey.getEncoded();

            // Convert password to bytes
            byte[] passwordBytes = password.getBytes();

            // Compare with secret key
            if (Base64.getEncoder().encodeToString(check).equals(Base64.getEncoder().encodeToString(secretKey.getEncoded()))) {
                return true;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("user", "password")); // Should print true
        System.out.println(validate("wrongUser", "wrongPassword")); // Should print false
    }
}