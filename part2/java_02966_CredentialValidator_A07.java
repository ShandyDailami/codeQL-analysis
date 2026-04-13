import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_02966_CredentialValidator_A07 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
        credentials.put("user1", "user1Password");
        credentials.put("user2", "user2Password");
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        String validPassword = credentials.get(username);
        return validPassword != null && validPassword.equals(password);
    }
}