import java.util.HashMap;
import java.util.Map;

public class java_21875_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_21875_CredentialValidator_A03() {
        // Create some sample credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the stored password for the provided username
        return password.equals(this.credentials.getOrDefault(username, null));
    }
}