import java.security.InvalidParameterException;

public class java_36617_CredentialValidator_A08 {
    // Method to check if password meets certain requirements
    private static boolean validatePassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        // Check if password contains at least one digit, one uppercase letter and one lowercase letter
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidParameterException("Password must contain at least one digit");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidParameterException("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidParameterException("Password must contain at least one lowercase letter");
        }

        // Password is valid if it matches the pattern
        return true;
    }

    // Method to validate Credentials
    public static boolean validateCredentials(String username, String password, String confirmPassword) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }

        if (!password.equals(confirmPassword)) {
            throw new InvalidParameterException("Passwords do not match");
        }

        // Check the password
        if (!validatePassword(password)) {
            throw new InvalidParameterException("Password is not strong enough");
        }

        // Credentials are valid if both passwords pass the validation
        return true;
    }
}