import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_25922_CredentialValidator_A08 {
    // Stored hash of the password
    private String storedHash;

    // Constructor
    public java_25922_CredentialValidator_A08(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        this.storedHash = Base64.getEncoder().encodeToString(hash);
    }

    // Method to authenticate a password
    public boolean authenticate(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash).equals(this.storedHash);
    }
}