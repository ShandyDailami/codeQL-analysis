import java.util.HashMap;
import java.util.Map;

public class java_12009_CredentialValidator_A03 {

    // Stored credentials
    private Map<String, String> credentials;

    // Constructor
    public java_12009_CredentialValidator_A03() {
        this.credentials = new HashMap<>();

        // Add predefined credentials
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "user1password");
    }

    // Method to validate username and password
    public boolean validateCredentials(String username, String password) {
        // Check if the credentials exist in our map
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}