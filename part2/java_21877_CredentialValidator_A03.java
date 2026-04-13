import java.security.InvalidParameterException;
import java.util.Base64;

public class java_21877_CredentialValidator_A03 {

    // A simple check for password strength.
    private static boolean checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (password.matches(".*[0-9].*")) {
            return false;
        }
        if (password.matches(".*[a-z].*")) {
            return false;
        }
        if (password.matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }
        if (!username.matches(".*@.*\\..*")) {
            throw new InvalidParameterException("Invalid username format.");
        }
        if (!checkPasswordStrength(password)) {
            throw new InvalidParameterException("Password must be at least 8 characters long and contain upper case, lower case, and a digit.");
        }
        // Here you can add more complex checks, such as checking the password against a database,
        // or validating the user against a third-party service.
        return true;
    }

    public static void main(String[] args) {
        validate("test@example.com", "Password123!");
    }
}