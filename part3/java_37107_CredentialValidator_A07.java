import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_37107_CredentialValidator_A07 {
    public boolean validate(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is too short (minimum required length)
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains any special characters
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Check if password contains any numbers
        if (!hasNumber(password)) {
            return false;
        }

        // Check if password contains any uppercase letters
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains any lowercase letters
        if (!hasLowerCase(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUpperCase(String password) {
        // Checks if password contains at least one uppercase letter
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        // Checks if password contains at least one lowercase letter
        return password.matches(".*[a-z].*");
    }

    private boolean hasNumber(String password) {
        // Checks if password contains at least one number
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        // Checks if password contains at least one special character
        return password.matches(".*[!@#$%^&*()_+\\-=\\[{\\}\\];:'\"\\|,.<>/?\\\\=\\\\\\]]+.*");
    }
}