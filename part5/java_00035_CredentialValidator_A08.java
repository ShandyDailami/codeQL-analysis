import java.util.HashMap;
import java.util.Map;

public class java_00035_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_00035_CredentialValidator_A08() {
        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the expected password
        if (this.credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}