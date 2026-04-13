import java.util.HashMap;
import java.util.Map;

public class java_32647_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_32647_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to access with invalid credentials
        System.out.println(validator.validate("invalid", "invalid")); // Should print: false

        // Try to access with valid credentials
        System.out.println(validator.validate("admin", "password")); // Should print: true
    }
}