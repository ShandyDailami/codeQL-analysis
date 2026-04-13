import java.util.HashMap;
import java.util.Map;

public class java_34468_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_34468_CredentialValidator_A01() {
        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password123");
        this.credentials.put("user1", "password123");
        this.credentials.put("user2", "password456");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if credentials are in the map
        if (this.credentials.containsKey(username)) {
            // Compare the provided password with the stored password
            return this.credentials.get(username).equals(password);
        } else {
            // In case the username doesn't exist, log an error and return false
            System.out.println("Invalid username or password");
            return false;
        }
    }
}