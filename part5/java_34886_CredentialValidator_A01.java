import java.util.HashMap;
import java.util.Map;

public class java_34886_CredentialValidator_A01 {
    // A map to hold the username and password pairs
    private Map<String, String> credentials;

    public java_34886_CredentialValidator_A01() {
        // Initialize the credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the inputted username and password match the stored ones
        return this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user3", "password3")); // false
    }
}