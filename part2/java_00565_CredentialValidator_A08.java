import java.util.Arrays;
import java.util.List;

public class java_00565_CredentialValidator_A08 {

    // List of allowed usernames and passwords
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true; // Valid credentials
        } else {
            return false; // Invalid credentials
        }
    }
}