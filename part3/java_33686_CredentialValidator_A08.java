import java.util.HashMap;
import java.util.Map;

public class java_33686_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_33686_CredentialValidator_A08() {
        // Initialize credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the provided password matches the stored password for the username
        if (credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}