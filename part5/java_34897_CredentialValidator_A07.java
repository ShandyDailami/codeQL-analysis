import java.util.HashMap;
import java.util.Map;

public class java_34897_CredentialValidator_A07 {
    // Define a HashMap to store user credentials
    private Map<String, String> credentials;

    public java_34897_CredentialValidator_A07() {
        // Initialize the credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // If the username and password match the credentials in the map
        // return true, otherwise return false
        if (credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to log in as user1
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Successfully logged in as user1!");
        } else {
            System.out.println("Failed to log in as user1!");
        }

        // Try to log in as user2
        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("Successfully logged in as user2!");
        } else {
            System.out.println("Failed to log in as user2!");
        }
    }
}