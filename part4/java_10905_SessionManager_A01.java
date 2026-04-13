import java.util.HashMap;
import java.util.Map;

public class java_10905_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10905_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID cannot be empty");
        }
        if (userId == null || userId.length() == 0) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID cannot be empty");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID cannot be empty");
        }
        sessionMap.remove(sessionId);
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }
}