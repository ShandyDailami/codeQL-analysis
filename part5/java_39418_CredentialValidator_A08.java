import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_39418_CredentialValidator_A08 {

    // Stored hash of the password
    private String storedPasswordHash;

    // Constructor
    public java_39418_CredentialValidator_A08(String password) {
        try {
            this.storedPasswordHash = this.hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Method to hash the password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to validate the password
    public boolean isValidPassword(String password) {
        try {
            return this.hashPassword(password).equals(this.storedPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("testPassword");
        System.out.println(validator.isValidPassword("testPassword")); // true
        System.out.println(validator.isValidPassword("wrongPassword")); // false
    }
}