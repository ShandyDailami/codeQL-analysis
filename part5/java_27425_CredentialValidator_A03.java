import java.util.HashMap;
import java.util.Map;

public class java_27425_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_27425_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Valid credentials
        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is valid: " + isValid);  // Should print: Is valid: true

        // Invalid credentials
        isValid = validator.validate("admin", "wrongpassword");
        System.out.println("Is valid: " + isValid);  // Should print: Is valid: false
    }
}