import java.util.HashMap;
import java.util.Map;

public class java_39554_CredentialValidator_A01 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(String username, String password) {
                // Create a map with hardcoded credentials
                Map<String, String> credentials = new HashMap<>();
                credentials.put("user1", "password1");
                credentials.put("user2", "password2");

                // Validate the provided username and password
                return (credentials.get(username).equals(password));
            }
        };

        // Test the validator
        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user2", "password2")); // true
        System.out.println(validator.validate("user1", "wrong_password")); // false
    }
}

class CredentialValidator {
    public boolean validate(String username, String password) {
        throw new UnsupportedOperationException();
    }
}