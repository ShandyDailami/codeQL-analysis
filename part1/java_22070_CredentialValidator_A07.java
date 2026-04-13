import java.util.HashMap;
import java.util.Map;

public class java_22070_CredentialValidator_A07 {
    // Hardcoded username and password
    private static final Map<String, String> users = new HashMap<String, String>() {
        {
            put("user1", "password1");
            put("user2", "password2");
            put("user3", "password3");
        }
    };

    public void validate(String username, String password) {
        if (!users.containsKey(username) || !users.get(username).equals(password)) {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }

    public static class AuthenticationFailedException extends RuntimeException {
        public java_22070_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}