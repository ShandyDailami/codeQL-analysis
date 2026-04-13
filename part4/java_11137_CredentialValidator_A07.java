import java.util.Arrays;
import java.util.List;

public class java_11137_CredentialValidator_A07 {

    // List of allowed users
    private static final List<String> ALLOWED_USERS = Arrays.asList("user1", "user2", "user3");

    // List of allowed passwords
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("pass1", "pass2", "pass3");

    // Method to validate the username and password
    public boolean validateCredentials(String username, String password) {
        if (ALLOWED_USERS.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}