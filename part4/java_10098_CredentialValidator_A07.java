import java.util.HashMap;
import java.util.Map;

public class java_10098_CredentialValidator_A07 {

    // Map to store username and passwords
    private Map<String, String> credentials;

    public java_10098_CredentialValidator_A07() {
        // Create a simple map for the sake of this example
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the provided username and password match those in our map
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate some users
        boolean isValid1 = validator.validate("user1", "password1");
        boolean isValid2 = validator.validate("user2", "wrongpassword");
        boolean isValid3 = validator.validate("nonexistentuser", "password");

        // Print the results
        System.out.println("User1 is valid: " + isValid1);
        System.out.println("User2 is valid: " + isValid2);
        System.out.println("User3 is valid: " + isValid3);
    }
}