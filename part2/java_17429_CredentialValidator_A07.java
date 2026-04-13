import java.util.HashMap;
import java.util.Map;

public class java_17429_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_17429_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true

        isValid = validator.validate("invalidUser", "wrongPassword");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? false
    }
}