import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_41458_CredentialValidator_A01 {

    // Define the minimum password length
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // Check if password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }
        return true;
    }

    // Check if password is already hashed
    public boolean isPasswordAlreadyHashed(String password) {
        if (password.startsWith("{SHA}")) {
            return true;
        }
        return false;
    }

    // Hash password if it's not already hashed
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        if (!isPasswordAlreadyHashed(password)) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } else {
            return password;
        }
    }
}