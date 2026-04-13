import java.util.Arrays;
import java.util.List;

public class java_41219_CredentialValidator_A08 {

    // A list of predefined usernames and passwords
    private static final List<String> predefinedUsers = Arrays.asList("user1", "user2", "admin");
    private static final List<String> predefinedPasswords = Arrays.asList("password1", "password2", "adminpassword");

    // Custom method for validating credentials
    public boolean validateCredentials(String username, String password) {
        if (predefinedUsers.contains(username) && predefinedPasswords.contains(password)) {
            System.out.println("Authentication successful for user: " + username);
            return true; // Authentication successful
        } else {
            System.out.println("Authentication failed for user: " + username);
            return false; // Authentication failed
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Test valid credentials
        validator.validateCredentials("user1", "password1");

        // Test invalid credentials
        validator.validateCredentials("invalidUser", "invalidPassword");
    }
}