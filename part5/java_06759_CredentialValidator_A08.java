import java.util.HashMap;
import java.util.Map;

public class java_06759_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_06759_CredentialValidator_A08() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}