import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_13606_CredentialValidator_A03 {

    // A map to hold username and password pairs
    private Map<String, String> credentials;

    // Constructor
    public java_13606_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        // Add some hard-coded credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the hard-coded ones
        return this.credentials.get(username).equals(password);
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to log in with valid credentials
        boolean isValid = validator.validateCredentials("user1", "password1");
        if (isValid) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials.");
        }

        // Attempt to log in with invalid credentials
        isValid = validator.validateCredentials("invalidUser", "invalidPassword");
        if (isValid) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}