import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_14270_CredentialValidator_A03 {

    // Method to hash the password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to validate password
    public boolean validatePassword(String enteredPassword, String storedPassword) throws NoSuchAlgorithmException {
        if (hashPassword(enteredPassword).equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}