import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_06205_CredentialValidator_A07 {

    // Set of valid usernames and passwords.
    private static final Set<String> VALID_USERNAMES = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> VALID_PASSWORDS = new HashSet<>(Arrays.asList("password1", "password2", "password3"));

    // Method to validate a username and password.
    public boolean validateCredentials(String username, String password) {
        return VALID_USERNAMES.contains(username) && VALID_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials.
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }

        // Test with invalid credentials.
        if (validator.validateCredentials("user4", "password4")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}