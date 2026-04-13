import java.util.HashMap;
import java.util.Map;

public class java_04758_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_04758_CredentialValidator_A01() {
        // Initialize the credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password are valid
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "password2");
        validator.validateCredentials("user3", "password3");
    }
}