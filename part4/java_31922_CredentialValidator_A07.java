import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_31922_CredentialValidator_A07 {

    // A list of allowed usernames and passwords
    private Map<String, String> allowedUsers = new HashMap<>();

    public java_31922_CredentialValidator_A07() {
        // Predefined list of allowed usernames and passwords
        allowedUsers.put("user1", "password1");
        allowedUsers.put("user2", "password2");
        allowedUsers.put("user3", "password3");
    }

    // The method to validate the username and password
    public boolean validate(String username, String password) {
        if(allowedUsers.containsKey(username) && allowedUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // A simple main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user2", "password2")); // true

        // Test with invalid credentials
        System.out.println(validator.validate("user1", "wrongpassword")); // false
        System.out.println(validator.validate("unknownuser", "unknownpassword")); // false
    }
}