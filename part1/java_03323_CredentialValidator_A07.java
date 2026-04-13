import java.util.HashMap;
import java.util.Map;

public class java_03323_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_03323_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Authenticate with valid credentials
        System.out.println(validator.validate("user1", "password1")); // true

        // Authenticate with invalid credentials
        System.out.println(validator.validate("user3", "wrongpassword")); // false
    }
}