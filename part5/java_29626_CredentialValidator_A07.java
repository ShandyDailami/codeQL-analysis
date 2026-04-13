import java.util.Arrays;
import java.util.List;

public class java_29626_CredentialValidator_A07 {
    // A list of allowed usernames and passwords.
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("username1", "username2", "username3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean isValid(String username, String password) {
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}