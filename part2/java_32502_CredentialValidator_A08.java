import java.util.HashMap;
import java.util.Map;

public class java_32502_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_32502_CredentialValidator_A08() {
        // Add some hardcoded credentials
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public void validate(String username, String password) throws CredentialFailureException {
        if (!credentials.containsKey(username) || !credentials.get(username).equals(password)) {
            throw new CredentialFailureException("Invalid username or password");
        }
    }

    public static class CredentialFailureException extends Exception {
        public java_32502_CredentialValidator_A08(String message) {
            super(message);
        }
    }
}