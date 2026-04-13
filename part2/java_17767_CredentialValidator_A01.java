import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_17767_CredentialValidator_A01 {
    private String hashedPassword;

    public java_17767_CredentialValidator_A01(String password) {
        this.hashedPassword = hashPassword(password);
    }

    public boolean validatePassword(String password) {
        return this.hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}