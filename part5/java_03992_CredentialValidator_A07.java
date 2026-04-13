import java.util.HashMap;
import java.util.Map;

public class java_03992_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_03992_CredentialValidator_A07() {
        // Initialize the credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        // Check if the provided credentials are valid
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        }
        return false;
    }
}