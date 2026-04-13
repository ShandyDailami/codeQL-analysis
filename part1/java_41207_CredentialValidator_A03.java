import java.util.HashMap;
import java.util.Map;

public class java_41207_CredentialValidator_A03 {
    // Map of valid usernames and passwords
    private Map<String, String> validUsers;

    public java_41207_CredentialValidator_A03() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // You can also use this method for creating the CredentialValidator programmatically
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with valid credentials
        System.out.println(validator.validate("user1", "password1")); // Prints: true

        // Validate with invalid credentials
        System.out.println(validator.validate("invalid", "invalid")); // Prints: false
    }
}