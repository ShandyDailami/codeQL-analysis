import java.util.Arrays;
import java.util.List;

public class java_33555_CredentialValidator_A01 {

    private List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Simulating a password check for username
        if ("wrongPassword".equals(password)) {
            return false;
        }

        return validUsers.contains(username) && "password".equals(password);
    }
}