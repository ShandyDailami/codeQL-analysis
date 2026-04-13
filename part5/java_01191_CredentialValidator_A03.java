import java.util.HashMap;
import java.util.Map;

public class java_01191_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_01191_CredentialValidator_A03() {
        // Initialize the credentials map.
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match a known credential.
        String correctPassword = credentials.get(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        }
        return false;
    }
}