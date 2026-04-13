import java.util.Arrays;
import java.util.List;

public class java_26625_CredentialValidator_A08 {
    // A list of acceptable usernames and passwords
    private List<String> acceptedUsernames = Arrays.asList("user1", "user2", "user3");
    private List<String> acceptedPasswords = Arrays.asList("password1", "password2", "password3");

    // The method to authenticate a user
    public boolean authenticate(String username, String password) {
        if (acceptedUsernames.contains(username) && acceptedPasswords.contains(password)) {
            System.out.println("Authentication successful for user: " + username);
            return true;
        } else {
            System.out.println("Authentication failed for user: " + username);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.authenticate("user1", "password1"); // Should print "Authentication successful for user: user1"
        validator.authenticate("wrongUser", "wrongPassword"); // Should print "Authentication failed for user: wrongUser"
        validator.authenticate("user1", "wrongPassword"); // Should print "Authentication failed for user: user1"
    }
}