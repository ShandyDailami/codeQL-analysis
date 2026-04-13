import java.util.HashMap;
import java.util.Map;

public class java_15637_CredentialValidator_A07 {

    // Store credentials in a HashMap
    private Map<String, String> credentials;

    // Constructor
    public java_15637_CredentialValidator_A07() {
        credentials = new HashMap<>();
        // Initialize credentials for testing
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the entered credentials match the stored credentials
        if (credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}