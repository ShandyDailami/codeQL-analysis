import java.util.regex.Pattern;

public class java_15286_CredentialValidator_A08 {
    // Minimum length of the password
    private static final int MIN_LENGTH = 8;

    // Regular expression to validate a password
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    // Check if a password is strong enough
    public boolean isStrongEnough(String password) {
        if (password.length() < MIN_LENGTH) {
            return false;
        }

        if (!Pattern.matches(PASSWORD_PATTERN, password)) {
            return false;
        }

        return true;
    }
}