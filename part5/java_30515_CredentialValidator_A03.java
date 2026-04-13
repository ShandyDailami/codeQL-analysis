import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_30515_CredentialValidator_A03 {
    // Store password hashes for demonstration purposes
    private static final String DUMMY_HASH = "$sha256$10000$DUMMY$";

    // Simple hash function for demonstration purposes
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Validate the password
    public static boolean validatePassword(String password) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(DUMMY_HASH);
    }

    public static void main(String[] args) {
        String testPassword = "test";
        System.out.println("Hashed password: " + hashPassword(testPassword));
        System.out.println("Valid password? " + validatePassword(testPassword));
    }
}