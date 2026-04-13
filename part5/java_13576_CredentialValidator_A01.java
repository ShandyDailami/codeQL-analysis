import java.util.HashMap;
import java.util.Map;

public class java_13576_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_13576_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        initializeCredentials();
    }

    private void initializeCredentials() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String correctPassword = credentials.get(username);

        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}