import java.util.HashMap;
import java.util.Map;

public class java_24700_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_24700_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        validator.validate("user1", "password1");

        // Test invalid credentials
        validator.validate("invalidUser", "invalidPassword");
    }
}