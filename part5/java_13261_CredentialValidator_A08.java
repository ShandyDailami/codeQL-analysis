import java.util.HashMap;
import java.util.Map;

public class java_13261_CredentialValidator_A08 {

    // Store credentials
    private Map<String, String> credentials;

    public java_13261_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the entered password matches the stored password
        if (this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("Access granted to user2");
        } else {
            System.out.println("Access denied for user2");
        }
    }
}