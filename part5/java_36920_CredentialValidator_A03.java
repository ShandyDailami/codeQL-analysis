import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_36920_CredentialValidator_A03 {
    public boolean validateCredentials(String username, String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Hash the password
            byte[] hash = digest.digest(password.getBytes());

            // Convert the hashed password to a Base64 string
            String hashBase64 = Base64.getEncoder().encodeToString(hash);

            // Assume the username and password are correct
            return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}