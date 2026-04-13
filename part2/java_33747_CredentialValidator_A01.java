import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_33747_CredentialValidator_A01 {
    private static final Set<String> VALID_USERNAMES = new HashSet<>(Arrays.asList("admin", "user1", "user2", "user3"));
    private static final Set<String> VALID_PASSWORDS = new HashSet<>(Arrays.asList("password", "12345", "admin", "root"));

    public boolean validate(String username, String password) {
        return VALID_USERNAMES.contains(username) && VALID_PASSWORDS.contains(password);
    }
}