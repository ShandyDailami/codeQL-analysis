import java.util.HashMap;
import java.util.Map;

public class java_28741_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_28741_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean isValid(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}