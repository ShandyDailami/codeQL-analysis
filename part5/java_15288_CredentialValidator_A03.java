import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_15288_CredentialValidator_A03 {

    private Map<String, String> credentialStore;

    public java_15288_CredentialValidator_A03() {
        // Initialize credentialStore with some default credentials.
        credentialStore = new HashMap<>();
        credentialStore.put("user1", "password1");
        credentialStore.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null.");
        }

        // Use Java Security API for validation.
        String expectedPassword = credentialStore.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}