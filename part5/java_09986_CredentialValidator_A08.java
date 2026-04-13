import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_09986_CredentialValidator_A08 {

    // Define a map of allowed usernames and passwords
    private Map<String, String> allowedUsers;

    public java_09986_CredentialValidator_A08() {
        allowedUsers = new HashMap<>();
        allowedUsers.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // Check if the username and password match an allowed user
        if (allowedUsers.containsKey(username) && allowedUsers.get(username).equals(password)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("admin", "password"));  // Should print true
        System.out.println(validator.validate("admin", "wrong_password"));  // Should print false
        System.out.println(validator.validate("user", "password"));  // Should print false
        System.out.println(validator.validate(null, null));  // Should throw exception
        System.out.println(validator.validate("admin", null));  // Should throw exception
    }
}