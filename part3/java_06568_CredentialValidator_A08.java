import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_06568_CredentialValidator_A08 {

    private static final String SPECIFIC_PATTERN = "password must match pattern [A-Za-z0-9]*";

    public boolean isValidPassword(String password) {
        // Check if password matches specific pattern
        if (!password.matches(SPECIFIC_PATTERN)) {
            return false;
        }

        // Check if password is too weak
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains a uppercase and a lowercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains a special character
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[{\\}\\];':\"\\|,.<>?\\/].*")) {
            return false;
        }

        return true;
    }
}