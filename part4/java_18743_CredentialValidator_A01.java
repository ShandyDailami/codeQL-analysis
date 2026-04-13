import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_18743_CredentialValidator_A01 {
    // A set of disallowed usernames and passwords
    private static final Set<String> BLOCKED_USERNAMES = new HashSet<>(Arrays.asList("blockedUser1", "blockedUser2", "blockedUser3"));
    private static final Set<String> BLOCKED_PASSWORDS = new HashSet<>(Arrays.asList("blockedPassword1", "blockedPassword2", "blockedPassword3"));

    public boolean validate(String username, String password) {
        // Check if the username is blocked
        if (BLOCKED_USERNAMES.contains(username)) {
            System.out.println("Access Denied: " + username + " is blocked.");
            return false;
        }

        // Check if the password is blocked
        if (BLOCKED_PASSWORDS.contains(password)) {
            System.out.println("Access Denied: " + password + " is blocked.");
            return false;
        }

        // If neither the username nor the password is blocked, allow the access
        System.out.println("Access Allowed: " + username + " has successfully logged in.");
        return true;
    }
}