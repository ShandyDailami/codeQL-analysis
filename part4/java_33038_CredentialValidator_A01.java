import java.util.HashMap;
import java.util.Map;

public class java_33038_CredentialValidator_A01 {
    // Pre-defined credentials
    private static final Map<String, String> predefinedCredentials = new HashMap<>() {{
        put("user1", "password1");
        put("user2", "password2");
        put("user3", "password3");
    }};

    public boolean validate(String username, String password) {
        // Check if the credentials exist in the map
        if (predefinedCredentials.containsKey(username) &&
            predefinedCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}