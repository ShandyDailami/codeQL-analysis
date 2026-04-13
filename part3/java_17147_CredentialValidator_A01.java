import java.util.HashMap;
import java.util.Map;

public class java_17147_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_17147_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

// Example usage
public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: true

        isValid = validator.validateCredentials("user3", "password3");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: false
    }
}