import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class java_23837_CredentialValidator_A03 {

    private static final List<String> ALLOWED_CREDENTIALS = Arrays.asList("user1", "user2", "user3");

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        if (!ALLOWED_CREDENTIALS.contains(username)) {
            return false;
        }

        // Assume the following code is a placeholder for a secure comparison of passwords
        // For the sake of this example, we're just comparing against a hard-coded hash
        return password.equals("password");
    }
}