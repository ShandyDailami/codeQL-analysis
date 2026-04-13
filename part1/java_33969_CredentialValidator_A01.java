import java.util.HashSet;
import java.util.Set;

public class java_33969_CredentialValidator_A01 {

    // Define a set of allowed users
    private static final Set<String> ALLOWED_USERS = new HashSet<>();

    static {
        ALLOWED_USERS.add("user1");
        ALLOWED_USERS.add("user2");
        ALLOWED_USERS.add("user3");
    }

    // Method to validate a user's credentials
    public boolean validate(String username, String password) {
        // This is a placeholder for a more complex validation logic.
        // For now, we're just checking if the username is in the allowed set.
        return ALLOWED_USERS.contains(username) && password.equals("password");
    }
}