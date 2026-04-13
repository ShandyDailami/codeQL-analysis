import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_31556_CredentialValidator_A03 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize credentials map with some hard-coded credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        boolean isValid = validator.validateCredentials("user1", "password1");

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }

        isValid = validator.validateCredentials("user4", "password4");

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}