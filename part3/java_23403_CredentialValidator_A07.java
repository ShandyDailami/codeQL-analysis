import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_23403_CredentialValidator_A07 {

    public boolean validateCredentials(String username, String password) {
        // For demonstration purposes, we'll use a simple hash of the password
        String hashedPassword = hashPassword(password);

        // Now we'll compare the hashed password with the stored one
        return hashedPassword.equals(getPasswordFromDatabase());
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }

    // For demonstration purposes, this is a simple way to get a hashed password
    // In a real-world scenario, you'd likely retrieve this from a secure source
    private String getPasswordFromDatabase() {
        return hashPassword("password"); // For demonstration purposes, use a hardcoded password
    }
}