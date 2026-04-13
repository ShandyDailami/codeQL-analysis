import java.util.HashMap;
import java.util.Map;

public class java_20857_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_20857_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        }
        String sessionId = generateSessionId(userId);
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    private String generateSessionId(String userId) {
        // TODO: Implement session ID generation logic. This is a simple example and not secure.
        return "session_" + userId;
    }

    public void invalidateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        // TODO: Implement invalidation logic. This is a simple example and not secure.
        sessionMap.remove(sessionId);
    }
}