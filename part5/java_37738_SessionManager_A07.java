import java.util.HashMap;
import java.util.Map;

public class java_37738_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_37738_SessionManager_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public String createSession(String username, String password) {
        if (isValidCredentials(username, password)) {
            String sessionId = generateSessionId();
            // Store the session in a secure location.
            return sessionId;
        } else {
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        // Remove the session from a secure location.
    }

    private boolean isValidCredentials(String username, String password) {
        return this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password);
    }

    // This is a placeholder for the session ID generation.
    private String generateSessionId() {
        return "sessionId";
    }
}