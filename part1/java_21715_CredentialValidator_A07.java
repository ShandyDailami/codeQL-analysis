import java.util.HashMap;
import java.util.Map;

public class java_21715_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_21715_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some example credentials for testing
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean isValid(String username, String password) {
        return credentials.containsKey(username) &&
                credentials.get(username).equals(password);
    }
}