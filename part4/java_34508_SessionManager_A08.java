import java.util.HashMap;
import java.util.Map;

public class java_34508_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34508_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String userId) {
        // Create a session for the user
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public void endSession(String sessionId) {
        // Remove a session
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        // Get user from session
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        // Check if session is active
        return sessionMap.containsKey(sessionId);
    }
}