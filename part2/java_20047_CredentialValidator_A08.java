import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_20047_CredentialValidator_A08 {
    // Hard-coded users and their passwords
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("alice", "password1");
        users.put("bob", "password2");
        users.put("charlie", "password3");
    }

    // Method to validate username and password
    public boolean validate(String username, String password) {
        // Check if user exists in the database
        if (users.containsKey(username)) {
            // Check if the password matches the one in the database
            if (users.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with valid credentials
        boolean isValid = validator.validate("alice", "password1");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true

        // Testing with invalid credentials
        isValid = validator.validate("alice", "wrongpassword");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? false
    }
}