import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_05620_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Credentials credentials) throws CredentialException {
        String password = credentials.getPassword();

        // Check if password is not null and is not empty
        if (password == null || password.isEmpty()) {
            throw new CredentialException("Password cannot be null or empty.");
        }

        // Check if password has a length of at least 8 characters
        if (password.length() < 8) {
            throw new CredentialException("Password must be at least 8 characters long.");
        }

        // Check if password contains at least one digit
        if (!hasDigit(password)) {
            throw new CredentialException("Password must contain at least one digit.");
        }

        // Check if password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            throw new CredentialException("Password must contain at least one uppercase letter.");
        }

        // Check if password contains at least one lowercase letter
        if (!hasLowerCase(password)) {
            throw new CredentialException("Password must contain at least one lowercase letter.");
        }

        // Check if password contains at least one special character
        if (!hasSpecialChar(password)) {
            throw new CredentialException("Password must contain at least one special character.");
        }

        return new CredentialValidatorResult.Success("User is validated successfully.");
    }

    // Method to check if password has a digit
    private boolean hasDigit(String password) {
        return Pattern.matches(".*\\d.*", password);
    }

    // Method to check if password has an uppercase letter
    private boolean hasUpperCase(String password) {
        return Pattern.matches(".*[A-Z].*", password);
    }

    // Method to check if password has a lowercase letter
    private boolean hasLowerCase(String password) {
        return Pattern.matches(".*[a-z].*", password);
    }

    // Method to check if password has a special character
    private boolean hasSpecialChar(String password) {
        return Pattern.matches(".*[^a-zA-Z0-9].*", password);
    }
}