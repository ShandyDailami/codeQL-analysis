import java.util.HashMap;
import java.util.Map;

public class java_39386_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39386_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void integrityCheck(String sessionId, String expectedUserId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }

        if (!sessionMap.get(sessionId).equals(expectedUserId)) {
            throw new SecurityException("Incorrect user ID in session: " + sessionId);
        }
    }
}