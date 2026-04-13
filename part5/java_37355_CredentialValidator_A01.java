// Import necessary libraries
import java.util.HashMap;
import java.util.Map;

public class java_37355_CredentialValidator_A01 {
    // Private data structure to store credentials
    private Map<String, String> credentials;

    // Constructor
    public java_37355_CredentialValidator_A01() {
        // Create a map to store username and password
        credentials = new HashMap<>();
        // Add some sample credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // If the username and password match a stored one
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        // Otherwise
        else {
            return false;
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Try to validate a user with valid credentials
        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        // Try to validate a user with invalid credentials
        if (validator.validate("user1", "invalidPassword")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }
    }
}