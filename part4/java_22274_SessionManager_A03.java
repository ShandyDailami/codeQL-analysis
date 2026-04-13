import java.util.HashMap;
import java.util.Map;

public class java_22274_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_22274_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String userId) {
        if (!isValidSessionId(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID: " + sessionId);
        }
        if (!isValidUserId(userId)) {
            throw new IllegalArgumentException("Invalid user ID: " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!isValidSessionId(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (!isValidSessionId(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    private boolean isValidSessionId(String sessionId) {
        // Check if sessionId is null or empty
        return sessionId != null && !sessionId.isEmpty();
    }

    private boolean isValidUserId(String userId) {
        // Check if userId is null or empty
        return userId != null && !userId.isEmpty();
    }
}