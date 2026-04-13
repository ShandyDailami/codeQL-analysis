import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_30197_CredentialValidator_A03 {

    private String storedPassword;

    public java_30197_CredentialValidator_A03() {
        // Create a hardcoded password for testing
        try {
            this.storedPassword = this.hashPassword("testPassword");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validatePassword(String password) {
        try {
            String hashedPassword = this.hashPassword(password);
            return hashedPassword.equals(this.storedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }
}