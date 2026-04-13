import java.util.HashMap;
import java.util.Map;

public class java_31775_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_31775_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Assume if the username or password is null or empty, they're invalid
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check if the provided password matches the expected password
        String expectedPassword = this.credentials.get(username);
        return password.equals(expectedPassword);
    }
}