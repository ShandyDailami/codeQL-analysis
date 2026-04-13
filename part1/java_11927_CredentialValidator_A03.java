import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_11927_CredentialValidator_A03 {

    // Hard-coded password to check against.
    private String hardCodedPassword;

    // Constructor that takes the hard-coded password.
    public java_11927_CredentialValidator_A03(String hardCodedPassword) {
        this.hardCodedPassword = this.encodePassword(hardCodedPassword);
    }

    // Method to check if the password provided is correct.
    public boolean validateCredentials(String passwordAttempt) {
        return this.encodePassword(passwordAttempt).equals(this.hardCodedPassword);
    }

    // Method to encode the password for storage.
    private String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}