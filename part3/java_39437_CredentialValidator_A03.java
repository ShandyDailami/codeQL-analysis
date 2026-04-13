import java.util.HashMap;
import java.util.Map;

public class java_39437_CredentialValidator_A03 {
    private Map<String, String> credentialStore;

    public java_39437_CredentialValidator_A03() {
        // Create a map to store the credentials
        credentialStore = new HashMap<>();

        // Add some dummy credentials
        credentialStore.put("user1", "password1");
        credentialStore.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the entered password matches the stored one
        return password.equals(credentialStore.get(username));
    }
}