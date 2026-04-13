import java.util.HashMap;
import java.util.Map;

public class java_41851_CredentialValidator_A08 {
    // A map to store the credentials
    private Map<String, String> credentials = new HashMap<>();

    // Constructor to initialize the credentials
    public java_41851_CredentialValidator_A08() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the username and password match the stored ones
        return credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean valid = validator.validate("user1", "password1");
        if (valid) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Invalid username or password");
        }
    }
}