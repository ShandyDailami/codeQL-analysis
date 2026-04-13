import java.util.HashMap;
import java.util.Map;

public class java_29656_SessionManager_A07 {
    // A map to hold the sessions.
    private Map<String, String> sessionMap;

    // Constructor.
    public java_29656_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}