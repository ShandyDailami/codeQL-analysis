import java.util.regex.Pattern;

public class java_00795_CredentialValidator_A03 {

    // Check if a password is strong enough
    public static boolean isStrongPassword(String password) {
        // At least 8 characters
        if (password.length() < 8) {
            return false;
        }
        // Contains at least one uppercase letter
        if (!Pattern.matches(".*[A-Z].*", password)) {
            return false;
        }
        // Contains at least one lowercase letter
        if (!Pattern.matches(".*[a-z].*", password)) {
            return false;
        }
        // Contains at least one special character
        if (!Pattern.matches(".*[@#$%^&*(),.?\":{}|<>].*", password)) {
            return false;
        }
        // Contains at least one digit
        if (!Pattern.matches(".*[0-9].*", password)) {
            return false;
        }
        return true;
    }

}