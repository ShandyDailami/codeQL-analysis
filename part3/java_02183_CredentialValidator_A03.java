import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_02183_CredentialValidator_A03 {

    private final String username;
    private final String password;

    public java_02183_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    public boolean isCredentialsValid() {
        // This is a simple comparison. In a real application, you would likely use
        // a more secure method to compare password hashes.
        return this.username.equals(this.password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}