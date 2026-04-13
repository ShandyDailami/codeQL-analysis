import java.util.HashMap;
import java.util.Map;

public class java_28663_CredentialValidator_A01 {
    // A map to hold username-password pairs
    private Map<String, String> credentials;

    // Constructor
    public java_28663_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match
        if (this.credentials.get(username) != null && this.credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}