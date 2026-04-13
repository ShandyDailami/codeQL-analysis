import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_36657_CredentialValidator_A01 {
    // A map to hold username and password
    private Map<String, String> credentials;

    // Constructor to initialize the credentials map
    public java_36657_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        initializeCredentials();
    }

    // Method to add credentials to the map
    private void initializeCredentials() {
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // If the username and password exist in the map, return true
        // otherwise, return false
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user2", "password2")); // true

        // Test with invalid credentials
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validator.validateCredentials("unknownuser", "unknownpassword")); // false
    }
}