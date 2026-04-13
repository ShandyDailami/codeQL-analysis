import java.util.Arrays;
import java.util.List;

public class java_37178_CredentialValidator_A01 {
    // List of pre-defined credentials
    private static final List<String> preDefinedCredentials = Arrays.asList("user1", "user2", "user3");

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password are in the list of pre-defined credentials
        return preDefinedCredentials.contains(username) && preDefinedCredentials.contains(password);
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with valid credentials
        System.out.println(validator.validateCredentials("user1", "user1")); // Should return true
        System.out.println(validator.validateCredentials("user4", "user1")); // Should return false
    }
}