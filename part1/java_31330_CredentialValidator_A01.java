import java.util.HashMap;
import java.util.Map;

public class java_31330_CredentialValidator_A01 {

    // A map of username to password
    private Map<String, String> credentials = new HashMap<>();

    // Initialize the map with predefined credentials
    {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Constructor
    public java_31330_CredentialValidator_A01() {
        // Initialize the map with predefined credentials
        // You could also load these from a database or other source
        // In this example, we are just initializing them in the constructor
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // If the username and password match, return true
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        // If the username and password do not match, return false
        return false;
    }
}