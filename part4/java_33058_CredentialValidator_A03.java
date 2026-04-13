import javax.naming.AuthenticationException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_33058_CredentialValidator_A03 {
    private static final Set<String> VALID_USERNAMES = new HashSet<>(Arrays.asList("admin", "user1", "user2", "user3"));
    private static final Set<String> VALID_PASSWORDS = new HashSet<>(Arrays.asList("password", "user1", "user2", "user3"));

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (VALID_USERNAMES.contains(username) && VALID_PASSWORDS.contains(password)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}