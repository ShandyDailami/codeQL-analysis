import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_32460_CredentialValidator_A01 {
    // Known password and hash
    private final String password;
    private final String hashedPassword;

    // Constructor
    public java_32460_CredentialValidator_A01(String password, String hashedPassword) {
        this.password = password;
        this.hashedPassword = hashedPassword;
    }

    // Method to validate the password
    public boolean validate() {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Hash the password
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Encode the hash to Base64
            String encodedHash = Base64.getEncoder().encodeToString(hash);

            // Compare the hashed password with the hashed password in the constructor
            return this.hashedPassword.equals(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}