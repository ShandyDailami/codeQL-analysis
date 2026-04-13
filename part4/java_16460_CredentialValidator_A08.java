import java.util.HashMap;
import java.util.Map;

public class java_16460_CredentialValidator_A08 {
    // A map to hold the predefined credentials
    private Map<String, String> credentials;

    // Constructor
    public java_16460_CredentialValidator_A08() {
        this.credentials = new HashMap<>();

        // Add some predefined credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // If the username and password match the ones in the map, return true
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user2", "password2")); // true

        // Test invalid credentials
        System.out.println(validator.validate("user1", "wrongpassword")); // false
        System.out.println(validator.validate("unknownuser", "anything")); // false
    }
}