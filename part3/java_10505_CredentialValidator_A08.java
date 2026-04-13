import java.util.HashMap;
import java.util.Map;

public class java_10505_CredentialValidator_A08 {
    // A map to store username and password
    private Map<String, String> userData;

    // Constructor
    public java_10505_CredentialValidator_A08() {
        userData = new HashMap<>();

        // Add some default users for testing
        userData.put("user1", "password1");
        userData.put("user2", "password2");
        userData.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // If the username and password match those in our data, return true
        if (userData.get(username).equals(password)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validator.validateCredentials("unknownuser", "anything")); // false
    }
}