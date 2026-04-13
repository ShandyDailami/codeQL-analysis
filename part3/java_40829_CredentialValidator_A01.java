import java.util.HashMap;
import java.util.Map;

public class java_40829_CredentialValidator_A01 {
    // Hardcoded credentials for demonstration purposes
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // Add more credentials as needed
    }

    // Method to validate the credentials
    public static boolean validateCredentials(String username, String password) {
        // Check if the credentials match
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator with some known credentials
        validateCredentials("user1", "password1"); // Should print "Credentials validated successfully."
        validateCredentials("user3", "password3"); // Should print "Invalid credentials."
    }
}