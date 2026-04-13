import java.util.Base64;

public class java_12916_CredentialValidator_A01 {
    // Method to check if password is valid
    public boolean validatePassword(String password) {
        // Check if password is longer than 6 characters
        if (password.length() > 6) {
            return true;
        }
        return false;
    }

    // Method to check if username is valid
    public boolean validateUsername(String username) {
        // Check if username is not null or empty
        if (username != null && !username.isEmpty()) {
            return true;
        }
        return false;
    }

    // Method to validate both username and password
    public boolean validateCredentials(String username, String password) {
        // Check if username and password are valid
        if (validateUsername(username) && validatePassword(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        // Test valid credentials
        boolean valid = validator.validateCredentials("user", "password");
        System.out.println("Valid: " + valid);

        // Test invalid password
        valid = validator.validateCredentials("user", "pass");
        System.out.println("Valid: " + valid);

        // Test invalid username
        valid = validator.validateCredentials("", "password");
        System.out.println("Valid: " + valid);
    }
}