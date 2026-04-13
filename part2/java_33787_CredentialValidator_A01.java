import java.util.HashMap;
import java.util.Map;

public class java_33787_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_33787_CredentialValidator_A01() {
        // Hard-coded credentials for testing
        this.credentials = new HashMap<String, String>() {
            {
                put("admin", "password");
                put("user1", "password1");
                put("user2", "password2");
            }
        };
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the hard-coded ones
        if (credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validateCredentials method
        validator.validateCredentials("admin", "password"); // Should print "Access granted for user: admin"
        validator.validateCredentials("user1", "password1"); // Should print "Access granted for user: user1"
        validator.validateCredentials("user3", "password3"); // Should print "Access denied for user: user3"
    }
}