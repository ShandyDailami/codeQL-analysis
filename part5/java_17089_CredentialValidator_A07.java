import java.util.HashMap;
import java.util.Map;

public class java_17089_CredentialValidator_A07 {

    // Mock database of usernames and passwords
    private static final Map<String, String> mockDatabase = new HashMap<>();

    static {
        mockDatabase.put("user1", "password1");
        mockDatabase.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if credentials exist in the database
        if (mockDatabase.containsKey(username) && mockDatabase.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean result = validator.validateCredentials("user1", "password1");
        System.out.println("Credentials valid: " + result);

        result = validator.validateCredentials("user3", "password3");
        System.out.println("Credentials valid: " + result);
    }
}