import java.util.HashMap;
import java.util.Map;

public class java_09373_CredentialValidator_A01 {

    // A map that stores the username and password
    private static Map<String, String> credentials = new HashMap<>();

    // Initialize the credentials
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // If the provided username and password match the stored credentials, return true
        if (credentials.get(username).equals(password)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        boolean isValid = validator.validate("user1", "password1");

        if (isValid) {
            System.out.println("Access granted for user: " + "user1");
        } else {
            System.out.println("Access denied for user: " + "user1");
        }

        isValid = validator.validate("user2", "password2");

        if (isValid) {
            System.out.println("Access granted for user: " + "user2");
        } else {
            System.out.println("Access denied for user: " + "user2");
        }
    }
}