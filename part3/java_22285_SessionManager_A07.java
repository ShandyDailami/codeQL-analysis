import java.util.HashMap;
import java.util.Map;

public class java_22285_SessionManager_A07 {
    // Session data storage
    private Map<String, String> sessionData;

    // Constructor
    public java_22285_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionData.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        return sessionData.getOrDefault(sessionId, null);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionData.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}