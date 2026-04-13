import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_01829_CredentialValidator_A03 {
    private String passwordHash;

    public java_01829_CredentialValidator_A03(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        this.passwordHash = Base64.getEncoder().encodeToString(hash);
    }

    public boolean isValid(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        String hashString = Base64.getEncoder().encodeToString(hash);
        return hashString.equals(this.passwordHash);
    }
}