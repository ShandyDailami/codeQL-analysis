import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_20310_CredentialValidator_A08 {
    // This is a placeholder for the real password,
    // it should not be stored in plain text.
    private String password = "securePassword";

    public boolean validateCredentials(String userName, String password) {
        return this.password.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}