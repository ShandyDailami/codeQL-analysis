import java.security.InvalidParameterException;

public class java_36350_CredentialValidator_A07 implements CredentialValidator {
    // Constants for the required password criteria
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()_+=-=[]{};:'\",.<>?[`~]";

    public boolean validate(String username, String password) {
        // Check password length
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long.");
        }

        // Check for allowed special characters
        if (password.matches("[`~]")) {
            throw new InvalidParameterException("Password must not contain the symbol '~'.");
        }

        // If we've made it this far, the password is valid
        return true;
    }
}