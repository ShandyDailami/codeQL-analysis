import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_01981_CredentialValidator_A01 {
    private String storedPassword;

    public java_01981_CredentialValidator_A01(String password) {
        this.storedPassword = this.hashPassword(password);
    }

    public boolean validatePassword(String password) {
        return this.hashPassword(password).equals(this.storedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.validatePassword("wrongPassword")); // prints false
        System.out.println(validator.validatePassword("password")); // prints true
    }
}