import java.util.HashSet;
import java.util.Set;

public class java_01433_CredentialValidator_A08 {
    private Set<String> allowedUsers;

    public java_01433_CredentialValidator_A08() {
        // Initialize the allowed users set.
        allowedUsers = new HashSet<>();
        allowedUsers.add("admin");
        allowedUsers.add("user1");
        allowedUsers.add("user2");
    }

    public boolean validate(String username, String password) {
        // Check if the username is in the allowed users set.
        // If it is, return true. Otherwise, return false.
        return allowedUsers.contains(username);
    }
}