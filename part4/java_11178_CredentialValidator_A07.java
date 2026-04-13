import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_11178_CredentialValidator_A07 {
    private Map<String, String> credentials = new HashMap<>();

    public java_11178_CredentialValidator_A07() {
        // Add some default credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Check if user and password are null
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null.");
        }

        // Check if user and password match the stored credentials
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}