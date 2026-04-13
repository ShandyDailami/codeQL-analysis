import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_06548_CredentialValidator_A08 {
    // Create a method to validate the password.
    public boolean validatePassword(String passwordToCheck) {
        // Encode the password to check against
        String encodedPassword = Base64.getEncoder().encodeToString(passwordToCheck.getBytes());

        // Assume that the real password is "correctPassword"
        String correctPassword = "correctPassword";

        // Encode the correct password
        String correctPasswordEncoded = Base64.getEncoder().encodeToString(correctPassword.getBytes());

        // If the encoded passwords are the same, return true
        if (encodedPassword.equals(correctPasswordEncoded)) {
            return true;
        } else {
            return false;
        }
    }

    // Create a method to hash a password
    public String hashPassword(String passwordToHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(passwordToHash.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}