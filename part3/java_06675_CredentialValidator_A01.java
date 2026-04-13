import java.util.HashMap;
import java.util.Map;

public class java_06675_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_06675_CredentialValidator_A01() {
        // Hardcoded credentials
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean isValid(String username, String password) {
        // Check if the credentials map contains the provided username and password
        // and if they match
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}