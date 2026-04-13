import java.util.HashMap;
import java.util.Map;

public class java_04507_CredentialValidator_A08 {
    // A map to hold user credentials
    private Map<String, String> userCredentials;

    public java_04507_CredentialValidator_A08() {
        // Initialize the userCredentials map
        this.userCredentials = new HashMap<>();
        this.userCredentials.put("user1", "password1");
        this.userCredentials.put("user2", "password2");
    }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the provided username and password are in the map
        if (this.userCredentials.containsKey(username) && 
            this.userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}