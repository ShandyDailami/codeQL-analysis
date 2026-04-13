import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_39087_CredentialValidator_A08 implements CredentialValidator {

    // Hardcoded password for comparison.
    private String hardcodedPassword = "securePassword";

    // This method is called when a user attempts to log in.
    @Override
    public boolean validate(Credential c) {
        // Get the password entered by the user.
        String passwordAttempt = new String(c.getPassword(), StandardCharsets.UTF_8);

        // Hash the password entered by the user.
        String hashedAttempt = hashPassword(passwordAttempt);

        // Compare the hashed password entered by the user with the hashed hardcoded password.
        return hashedAttempt.equals(hashPassword(hardcodedPassword));
    }

    // Method for hashing a password.
    private String hashPassword(String password) {
        MessageDigest digest;
        byte[] hashbytes;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            // In case the algorithm does not exist, return null.
            return null;
        }
        // Convert the hash bytes to a hex string.
        return Base64.getEncoder().encodeToString(hashbytes);
    }
}