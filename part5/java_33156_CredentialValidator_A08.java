import java.util.Arrays;
import java.util.List;

public class java_33156_CredentialValidator_A08 {
    private static final List<String> USERS = Arrays.asList("user1", "user2", "user3");
    private static final List<String> PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        int index = USERS.indexOf(username);
        if (index == -1) {
            throw new IllegalArgumentException("Unknown user: " + username);
        }

        if (!PASSWORDS.get(index).equals(password)) {
            throw new IllegalArgumentException("Invalid password for user: " + username);
        }

        return true;
    }
}