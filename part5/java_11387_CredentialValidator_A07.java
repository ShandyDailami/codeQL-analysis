import java.util.HashMap;
import java.util.Map;

public class java_11387_CredentialValidator_A07 {

    // Define some predefined credentials
    private static final Map<String, String> credentials = new HashMap<String, String>() {{
        put("admin", "password123");
        put("user1", "password123");
        put("user2", "password456");
    }};

    public boolean isValid(String username, String password) {
        // Check if the provided username and password match the predefined set
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}