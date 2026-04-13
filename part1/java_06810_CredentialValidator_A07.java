import java.util.HashMap;
import java.util.Map;

public class java_06810_CredentialValidator_A07 {

    // A map to hold our credentials
    private Map<String, String> credentials;

    // Constructor
    public java_06810_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the provided username and password match our credentials
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        validator.validate("user1", "password1"); // Expected to return true
        validator.validate("user3", "password3"); // Expected to return false
    }
}