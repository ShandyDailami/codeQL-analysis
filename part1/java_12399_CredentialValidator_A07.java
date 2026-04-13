import java.util.Arrays;
import java.util.List;

public class java_12399_CredentialValidator_A07 {
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean validateCredentials(String username, String password) {
        if (isAllowedUser(username) && isAllowedPassword(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isAllowedUser(String username) {
        return ALLOWED_USERNAMES.contains(username);
    }

    private boolean isAllowedPassword(String password) {
        return ALLOWED_PASSWORDS.contains(password);
    }
}