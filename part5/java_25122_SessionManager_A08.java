import java.util.HashMap;
import java.util.Map;

public class java_25122_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25122_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean integrityCheck(String sessionId, String expectedUserId) {
        if (sessionExists(sessionId)) {
            String currentUserId = getUserId(sessionId);
            return currentUserId.equals(expectedUserId);
        }
        return false;
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}