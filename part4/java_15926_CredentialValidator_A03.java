import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_15926_CredentialValidator_A03 {

    // Check if the password is valid
    public boolean isValid(String password) {
        if (password == null || password.length() < 8 || password.length() > 16) {
            throw new InvalidParameterException("Invalid password length. Password must be between 8 and 16 characters long.");
        }

        // Check for uppercase, lowercase, digit, and special character
        if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", password)) {
            throw new InvalidParameterException("Invalid password format. Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
        }

        return true;
    }
}