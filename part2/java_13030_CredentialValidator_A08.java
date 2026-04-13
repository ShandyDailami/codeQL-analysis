import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_13030_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_13030_CredentialValidator_A08() {
        // Hardcoded credentials for demonstration purposes.
        // This should be replaced with a database or other form of persistent storage.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match a saved one.
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        throw new InvalidParameterException("Invalid username or password");
    }

    public static void main(String[] args) {
        SimpleCredentialValidator validator = new SimpleCredentialValidator();
        try {
            validator.validateCredentials("user1", "password1"); // Valid credentials
            validator.validateCredentials("user3", "password3"); // Invalid credentials
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}