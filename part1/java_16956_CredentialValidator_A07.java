import java.util.HashMap;
import java.util.Map;

public class java_16956_CredentialValidator_A07 {
    // A map to hold usernames and passwords.
    private Map<String, String> credentials;

    public java_16956_CredentialValidator_A07() {
        // Initialize the credentials map.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate the username and password.
    public boolean validate(String username, String password) {
        // If the credentials map does not contain the provided username, or if the
        // password for the username does not match the provided password, return false.
        if (!this.credentials.containsKey(username) || !this.credentials.get(username).equals(password)) {
            return false;
        }

        // If all checks have passed, return true.
        return true;
    }

    // Entry point for the program.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator.
        System.out.println(validator.validate("user1", "password1")); // Expected: true
        System.out.println(validator.validate("user3", "password3")); // Expected: false
        System.out.println(validator.validate("user1", "wrongpassword")); // Expected: false
    }
}