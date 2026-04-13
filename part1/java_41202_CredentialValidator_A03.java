import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class java_41202_CredentialValidator_A03 {
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password", "secret");

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        return ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password);
    }
}