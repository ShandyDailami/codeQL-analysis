import java.util.HashMap;
import java.util.Map;

public class java_02636_CredentialValidator_A08 {
    // Use a HashMap to store user credentials
    private Map<String, String> credentials;

    public java_02636_CredentialValidator_A08() {
        // Initialize credentials as a HashMap
        this.credentials = new HashMap<>();
        // Add some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the given username exists in the credentials map
        if (this.credentials.containsKey(username)) {
            // Check if the given password matches the stored password for the given username
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}