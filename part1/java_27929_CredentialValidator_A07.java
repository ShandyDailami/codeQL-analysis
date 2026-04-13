import java.util.HashMap;
import java.util.Map;

public class java_27929_CredentialValidator_A07 {

    private Map<String, String> credentials = new HashMap<>();

    public java_27929_CredentialValidator_A07() {
        // Add some credentials for testing
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        System.out.println(validator.validateCredentials("admin", "password")); // Should print: true
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print: true

        // Test invalid credentials
        System.out.println(validator.validateCredentials("admin", "wrongpassword")); // Should print: false
        System.out.println(validator.validateCredentials("nonexistentuser", "nonexistentpassword")); // Should print: false
    }
}