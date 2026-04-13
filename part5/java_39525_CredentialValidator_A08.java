import java.util.HashMap;
import java.util.Map;

public class java_39525_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_39525_CredentialValidator_A08() {
        credentials = new HashMap<>();
        // Add some dummy credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String storedPassword = credentials.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: true

        isValid = validator.validateCredentials("user4", "password4");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: false
    }
}