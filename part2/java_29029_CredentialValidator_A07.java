import java.util.HashMap;
import java.util.Map;

public class java_29029_CredentialValidator_A07 {

    // Create a map to store usernames and passwords
    private Map<String, String> userMap;

    // Constructor
    public java_29029_CredentialValidator_A07() {
        this.userMap = new HashMap<>();
        // Add some dummy users
        this.userMap.put("user1", "password1");
        this.userMap.put("user2", "password2");
        this.userMap.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password are in the map
        if (this.userMap.containsKey(username) && this.userMap.get(username).equals(password)) {
            // If they are, return true
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validateCredentials method
        System.out.println(validator.validateCredentials("user1", "password1")); // should print true
        System.out.println(validator.validateCredentials("user1", "wrong_password")); // should print false
        System.out.println(validator.validateCredentials("wrong_username", "password1")); // should print false
    }
}