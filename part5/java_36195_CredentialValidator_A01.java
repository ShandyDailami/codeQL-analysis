import java.util.HashSet;
import java.util.Set;

public class java_36195_CredentialValidator_A01 {

    // Define the allowed users and passwords.
    private Set<String> allowedUsers = new HashSet<>();
    private Set<String> allowedPasswords = new HashSet<>();

    public java_36195_CredentialValidator_A01() {
        // Initialize allowed users and passwords.
        allowedUsers.add("user1");
        allowedUsers.add("user2");
        allowedPasswords.add("password1");
        allowedPasswords.add("password2");
    }

    public boolean validate(String username, String password) {
        // Check if the username and password are in the allowed list.
        return allowedUsers.contains(username) && allowedPasswords.contains(password);
    }
}