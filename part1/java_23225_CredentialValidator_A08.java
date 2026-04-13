import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23225_CredentialValidator_A08 {

    // Predefined set of credentials.
    private Map<String, String> credentials = new HashMap<>();

    public java_23225_CredentialValidator_A08() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean isValidCredentials(String username, String password) {
        String expectedPassword = credentials.get(username);

        // This is a very basic example of a password hashing function.
        // In a real-world application, you would likely use a more secure
        // hash function like SHA-256 or Bcrypt.
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] key = skf.parseSecret(expectedPassword);

            SecretKey secretKey = skf.generateSecret(new PBEKeySpec(password.toCharArray(), key, 10000, 256));

            String encryptedPassword = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            return expectedPassword.equals(encryptedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
            return false;
        }
    }
}