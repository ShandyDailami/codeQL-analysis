import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class java_25546_CredentialValidator_A08 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$");

    public boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean areCredentialsValid(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            return false;
        }

        // In a real application, you'd typically fetch the password hash from a database
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // This is a simple implementation, in a real application you'd also compare the hash
            return true;
        } catch (NoSuchAlgorithmException e) {
            // Should not happen, SHA-256 is a standard algorithm
            return false;
        }
    }
}