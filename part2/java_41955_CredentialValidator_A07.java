import java.util.HashMap;
import java.util.Map;

public class java_41955_CredentialValidator_A07 {
    // Storing credentials (username, password) in a map
    private Map<String, String> credentials;

    // Constructor
    public java_41955_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method for validating username and password
    public boolean validateCredentials(String username, String password) {
        // If the username exists in the map, return true if the password matches
        if (this.credentials.containsKey(username)) {
            return this.credentials.get(username).equals(password);
        }

        // If the username doesn't exist in the map, return false
        return false;
    }
}