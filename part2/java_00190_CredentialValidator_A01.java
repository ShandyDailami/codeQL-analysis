// Import the necessary classes
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

// Define the CredentialValidator
public class java_00190_CredentialValidator_A01 {
    // The credentials map
    private Map<String, String> credentials;

    // Constructor
    public java_00190_CredentialValidator_A01() {
        // Initialize the credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Check if the credentials exist in the map
        if (this.credentials.containsKey(username)) {
            // Compare the hashed passwords
            return this.credentials.get(username).equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            // If the username does not exist, return false
            return false;
        }
    }
}