import java.util.HashMap;
import java.util.Map;

public class java_03508_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_03508_CredentialValidator_A07() {
        // Mock credentials. Replace these with actual data.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // Check if credentials exist for the given username.
        if (this.credentials.containsKey(username)) {
            // If the password matches the stored password for this username, return true.
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        // Otherwise, return false.
        return false;
    }
}