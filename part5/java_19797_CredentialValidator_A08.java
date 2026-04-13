import java.util.HashMap;
import java.util.Map;

public class java_19797_CredentialValidator_A08 {
    // Store hardcoded credentials in a map
    private Map<String, String> credentials;

    public java_19797_CredentialValidator_A08() {
        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user", "userpassword");
    }

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        // If the entered credentials match the hardcoded credentials, return true
        if (this.credentials.get(username).equals(password)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}