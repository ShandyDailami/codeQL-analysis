import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_20911_CredentialValidator_A01 {
    private MessageDigest md;

    public java_20911_CredentialValidator_A01() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateCredentials(String username, String password) {
        String passwordHash = getPasswordHash(password);
        return passwordHash.equals(getPasswordHash(password));
    }

    private String getPasswordHash(String password) {
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}