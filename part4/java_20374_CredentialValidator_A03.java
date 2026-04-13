import java.util.HashMap;
import java.util.Map;

public class java_20374_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_20374_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        initializeCredentials();
    }

    private void initializeCredentials() {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username)) {
            return credentials.get(username).equals(password);
        } else {
            return false;
        }
    }
}