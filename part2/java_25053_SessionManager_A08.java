import java.util.HashMap;
import java.util.Map;

public class java_25053_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25053_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (userId == null || userId.length() == 0) {
            throw new IllegalArgumentException("User ID must not be null or empty");
        }
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        sessionMap.remove(sessionId);
    }
}