import java.util.HashMap;
import java.util.Map;

public class java_00949_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_00949_CredentialValidator_A07() {
        // Initialize credentials for demonstration purposes
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean isValid(String user, String password) {
        if (!credentials.containsKey(user) || !credentials.get(user).equals(password)) {
            // Assume all failed attempts are "AuthFailure"
            System.out.println("AuthFailure: Invalid credentials for user: " + user);
            return false;
        }

        System.out.println("AuthSuccess: User: " + user + " authenticated successfully");
        return true;
    }
}