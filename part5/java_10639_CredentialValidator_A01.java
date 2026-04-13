import java.util.HashMap;
import java.util.Map;

public class java_10639_CredentialValidator_A01 {
    private Map<String, String> credentials = new HashMap<>();

    public java_10639_CredentialValidator_A01() {
        // Add some default credentials
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