import java.util.HashMap;
import java.util.Map;

public class java_25199_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_25199_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Create a new session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get the user id from the session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Check if the session exists
    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Utility method to generate a session id
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}