import java.util.HashMap;
import java.util.Map;

public class java_16447_CredentialValidator_A07 {

    // A map to hold the expected values
    private static Map<String, String> expectedValues = new HashMap<>();

    static {
        expectedValues.put("user1", "password1");
        expectedValues.put("user2", "password2");
        // add more users as needed
    }

    // The actual method that will validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match the expected values
        if (expectedValues.containsKey(username) && expectedValues.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Test with valid credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }

        // Test with invalid credentials
        if (validator.validateCredentials("invalidUser", "invalidPassword")) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}