import java.util.HashMap;
import java.util.Map;

public class java_39790_CredentialValidator_A08 {

    // In-memory storage for username-password pairs.
    private Map<String, String> credentials;

    public java_39790_CredentialValidator_A08() {
        // Initialize credentials map.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the stored password for the given username.
        // This is a basic example and does not include any additional security measures.
        // In a real-world scenario, you would typically hash the password and compare the hashes.
        return this.credentials.get(username).equals(password);
    }
}