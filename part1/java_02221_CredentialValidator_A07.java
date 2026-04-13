import java.util.HashMap;
import java.util.Map;

public class java_02221_CredentialValidator_A07 {

    // Map to hold user names and passwords
    private Map<String, String> userMap;

    // Constructor
    public java_02221_CredentialValidator_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    // Method to validate user credentials
    public boolean validateUser(String user, String password) {
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempting to login with invalid credentials
        boolean isValid = validator.validateUser("invalidUser", "wrongPassword");
        System.out.println("Login attempt failed: " + isValid);

        // Attempting to login with valid credentials
        isValid = validator.validateUser("user1", "password1");
        System.out.println("Login attempt succeeded: " + isValid);
    }
}