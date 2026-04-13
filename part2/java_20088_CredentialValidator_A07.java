import java.util.HashMap;
import java.util.Map;

public class java_20088_CredentialValidator_A07 {
    // Pre-defined credentials
    private Map<String, String> credentials;

    // Constructor
    public java_20088_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the pre-defined credentials
        return this.credentials.get(username).equals(password);
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Validated successfully.");
        } else {
            System.out.println("Validation failed.");
        }

        // Test with invalid credentials
        if (!validator.validateCredentials("invalidUser", "invalidPassword")) {
            System.out.println("Validated successfully.");
        } else {
            System.out.println("Validation failed.");
        }
    }
}