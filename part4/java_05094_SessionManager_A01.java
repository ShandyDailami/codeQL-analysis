import java.util.HashMap;
import java.util.Map;

public class java_05094_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_05094_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.remove(sessionId);
    }

    public void updateUserId(String sessionId, String newUserId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (newUserId == null || newUserId.isEmpty()) {
            throw new IllegalArgumentException("New User ID cannot be null or empty");
        }
        sessionMap.replace(sessionId, newUserId);
    }
}