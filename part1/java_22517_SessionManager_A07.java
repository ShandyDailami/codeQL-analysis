import java.util.HashMap;
import java.util.Map;

public class java_22517_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22517_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isSessionValid(String sessionId, String expectedUserId) {
        if (!sessionExists(sessionId)) {
            return false;
        }
        String currentUserId = getUserIdBySession(sessionId);
        return currentUserId.equals(expectedUserId);
    }

    public void authFailure(String sessionId) {
        if (sessionExists(sessionId)) {
            removeSession(sessionId);
        }
    }
}