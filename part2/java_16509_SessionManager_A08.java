import java.util.HashMap;
import java.util.Map;

public class java_16509_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16509_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("SessionId and UserId must not be null");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId must not be null");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId must not be null");
        }
        sessionMap.remove(sessionId);
    }

    public void deleteUser(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("UserId must not be null");
        }
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }

    public void updateSession(String sessionId, String newUserId) {
        if (sessionId == null || newUserId == null) {
            throw new IllegalArgumentException("SessionId and NewUserId must not be null");
        }
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserId);
        } else {
            throw new IllegalArgumentException("Invalid SessionId");
        }
    }

    public boolean sessionExists(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId must not be null");
        }
        return sessionMap.containsKey(sessionId);
    }

    public boolean userExists(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("UserId must not be null");
        }
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}