import java.util.HashMap;
import java.util.Map;

public class java_38026_CredentialValidator_A01 {

    // Create a map to store user credentials
    private Map<String, String> credentials;

    // Constructor
    public java_38026_CredentialValidator_A01() {
        credentials = new HashMap<>();
        // Add default credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match the stored credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}