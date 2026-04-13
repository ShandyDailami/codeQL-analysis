import java.util.HashMap;
import java.util.Map;

public class java_21747_CredentialValidator_A01 {

    // Create a map to store user credentials
    private Map<String, String> credentials;

    // Constructor
    public java_21747_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Add some sample credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // If the username and password match the stored credentials, return true
        if (this.credentials.get(username).equals(password)) {
            return true;
        }
        // If the credentials do not match, return false
        return false;
    }
}