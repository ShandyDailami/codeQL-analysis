import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_08337_CredentialValidator_A01 {
    // Stored password hash in the database
    private String hashedPassword;

    public java_08337_CredentialValidator_A01(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        this.hashedPassword = Base64.getEncoder().encodeToString(hash);
    }

    // Method for user input
    public boolean validate(String inputPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(inputPassword.getBytes());
        String inputHashedPassword = Base64.getEncoder().encodeToString(hash);
        return this.hashedPassword.equals(inputHashedPassword);
    }
}