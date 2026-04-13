import java.util.Arrays;
import java.util.List;

public class java_08008_CredentialValidator_A07 {
    private static final List<String> ALLOWED_USERS = Arrays.asList("admin", "user1", "user2");

    public boolean validateCredentials(String username, String password) {
        // In a real application, you would typically use a more secure way to compare passwords
        // This example just compares the password to a hardcoded value
        return password.equals("password") && ALLOWED_USERS.contains(username);
    }
}