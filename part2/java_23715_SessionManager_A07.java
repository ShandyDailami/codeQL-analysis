import java.util.HashMap;
import java.util.Map;

public class java_23715_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23715_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Create a session ID using a user ID and the current time
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean validateSession(String sessionId) {
        // Assume that the session is valid if it exists in the map
        return sessionMap.containsKey(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}