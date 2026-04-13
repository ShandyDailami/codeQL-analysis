import java.util.HashMap;
import java.util.Map;

public class java_40476_CredentialValidator_A03 {

    // Static map to hold user credentials
    private static Map<String, String> userCredentials = new HashMap<>();

    // Static block to populate the user credentials
    static {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        validator.validateCredentials("user1", "password1"); // Should print: Credentials validated successfully!

        // Test with invalid credentials
        validator.validateCredentials("user4", "invalidpassword"); // Should print: Invalid username or password!
    }
}