import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_31566_CredentialValidator_A07 {
    // Set of disallowed usernames and passwords
    private static final Set<String> DISALLOWED_USERS = new HashSet<>(Arrays.asList("disallowed_user1", "disallowed_user2", "disallowed_user3"));
    private static final Set<String> DISALLOWED_PASSWORDS = new HashSet<>(Arrays.asList("disallowed_password1", "disallowed_password2", "disallowed_password3"));

    // Credential validation
    public boolean validate(String username, String password) {
        return !DISALLOWED_USERS.contains(username) && !DISALLOWED_PASSWORDS.contains(password);
    }
}