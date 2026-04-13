import java.util.HashMap;
import java.util.Map;

public class java_15130_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_15130_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("Session ID and User ID must not be null");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        sessionMap.remove(sessionId);
    }

    public void deleteUser(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }

    public boolean isUserPresent(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        return sessionMap.containsValue(userId);
    }

    public boolean isSessionPresent(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.containsKey(sessionId);
    }
}