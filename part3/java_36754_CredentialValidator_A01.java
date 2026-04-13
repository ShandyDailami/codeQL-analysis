import java.util.HashMap;
import java.util.Map;

public class java_36754_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_36754_CredentialValidator_A01() {
        // Add some example credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // If the credentials map is empty, there are no credentials to validate
        if (credentials.isEmpty()) {
            return false;
        }

        // Validate the provided password against the stored password for the provided username
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}