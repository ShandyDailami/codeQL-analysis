import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23124_CredentialValidator_A03 {

    // Create a map to store credentials
    private Map<String, String> credentials = new HashMap<>();

    // Constructor to initialize credentials
    public java_23124_CredentialValidator_A03() {
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method to validate user credentials
    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user)) {
            return credentials.get(user).equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to log in with valid credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // Should print true
        System.out.println(validator.validateCredentials("user3", "password3")); // Should print false
    }
}