import java.util.HashMap;
import java.util.Map;

public class java_10139_CredentialValidator_A01 {

    // Define a map of hard-coded credentials
    private Map<String, String> credentials;

    // Constructor
    public java_10139_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username is in the map
        if (credentials.containsKey(username)) {
            // Check if the provided password matches the one in the map
            if (credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}