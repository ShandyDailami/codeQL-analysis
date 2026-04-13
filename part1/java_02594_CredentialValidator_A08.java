import java.util.HashMap;
import java.util.Map;

public class java_02594_CredentialValidator_A08 {

    // Assume a database to store credentials
    private Map<String, String> credentials;

    public java_02594_CredentialValidator_A08() {
        // Initialize the credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match those in the map
        return password.equals(credentials.get(username));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to validate the credentials
        boolean valid = validator.validateCredentials("user1", "password1");

        if (valid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}