import java.util.HashMap;
import java.util.Map;

public class java_24189_SessionManager_A07 {
    // Create a Map for session storage.
    private Map<String, String> sessionMap;

    public java_24189_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Simulate a real-world authentication process.
        // In a real-world scenario, you'd probably have a more complex authentication mechanism.
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid session: " + sessionId);
        }
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}