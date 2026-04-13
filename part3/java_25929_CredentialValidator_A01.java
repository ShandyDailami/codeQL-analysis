import java.security.InvalidParameterException;

public class java_25929_CredentialValidator_A01 {
    // Constants for password strength requirements
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;
    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_=-";

    // Check if password is valid
    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        // Check password length
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[ " + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }
}