import java.util.HashSet;
import java.util.Set;

public class java_25329_CredentialValidator_A07 {
    // predefined list of allowed usernames and passwords
    private Set<String> allowedUsers = new HashSet<String>() {{
        add("user1");
        add("user2");
        add("user3");
    }};

    private Set<String> allowedPasswords = new HashSet<String>() {{
        add("password1");
        add("password2");
        add("password3");
    }};

    // Method to validate the user's credential
    public boolean validate(String username, String password) {
        return allowedUsers.contains(username) && allowedPasswords.contains(password);
    }
}