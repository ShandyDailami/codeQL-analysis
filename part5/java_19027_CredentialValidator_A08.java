import java.util.HashMap;
import java.util.Map;

public class java_19027_CredentialValidator_A08 {

    // Predefined list of credentials
    private Map<String, String> credentials;

    public java_19027_CredentialValidator_A08() {
        // Initialize credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate the user's credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the credentials exist in the map
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print true
        System.out.println(validator.validateCredentials("user3", "password3")); // Should print false
    }
}