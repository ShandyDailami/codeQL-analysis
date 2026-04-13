import java.util.HashMap;
import java.util.Map;

public class java_31449_CredentialValidator_A08 {
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username)) {
            return credentials.get(username).equals(password);
        } else {
            return false;
        }
    }
}