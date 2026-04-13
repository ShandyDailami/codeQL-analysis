import java.util.HashMap;
import java.util.Map;

public class java_05398_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_05398_CredentialValidator_A07() {
        // Initialize credentials map.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if provided username and password matches a stored credential.
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to validate credentials
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: true

        isValid = validator.validateCredentials("user4", "password4");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: false
    }
}