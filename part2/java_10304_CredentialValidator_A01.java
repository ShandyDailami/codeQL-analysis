import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_10304_CredentialValidator_A01 {
    private String securePassword;

    public java_10304_CredentialValidator_A01(String password) {
        this.securePassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean validatePassword(String password) {
        return this.securePassword.equals(hashPassword(password));
    }
}