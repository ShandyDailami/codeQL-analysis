import java.util.HashMap;
import java.util.Map;

public class java_13048_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_13048_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public void validate(String username, String password) throws CredentialException {
        if (username == null || password == null) {
            throw new CredentialException("Username or password is null");
        }

        if (!this.credentials.containsKey(username)) {
            throw new CredentialException("Invalid username");
        }

        if (!this.credentials.get(username).equals(password)) {
            throw new CredentialException("Invalid password");
        }
    }

    public static class CredentialException extends Exception {
        public java_13048_CredentialValidator_A01(String message) {
            super(message);
        }
    }
}