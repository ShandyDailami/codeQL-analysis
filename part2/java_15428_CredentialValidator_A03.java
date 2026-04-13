import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_15428_CredentialValidator_A03 {
    // This method is used to hash a password for storage
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }

    // This method is used to verify a password against a stored hash
    public boolean verifyPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}