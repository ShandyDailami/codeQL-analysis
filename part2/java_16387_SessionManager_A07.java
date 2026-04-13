import java.util.HashMap;
import java.util.Map;

public class java_16387_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16387_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found for user: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found for user: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public void checkAuthFailure(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found for user: " + sessionId);
        }
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            throw new RuntimeException("User not authenticated for session: " + sessionId);
        }
        // Check for other authentication failures...
    }
}