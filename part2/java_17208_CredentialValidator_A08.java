import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_17208_CredentialValidator_A08 {

    private static final String HASHED_PASSWORD = "1a34"; // Hashed version of "password"

    // Function to hash password
    private static String hashPassword(String password) {
        MessageDigest digest;
        byte[] hashedBytes;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    // Method to validate password
    public static boolean validatePassword(String password) {
        return hashPassword(password).equals(HASHED_PASSWORD);
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(validatePassword("password")); // Should print true
        System.out.println(validatePassword("wrongPassword")); // Should print false
    }
}