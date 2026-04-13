import java.util.HashMap;
import java.util.Map;

public class java_28296_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28296_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        }
    }

    public void integrityCheck(String sessionId, String expectedUserId) {
        String userId = getUserIdFromSession(sessionId);
        if (userId == null || !userId.equals(expectedUserId)) {
            throw new SecurityFailureException("Session integrity check failed.");
        }
    }
}