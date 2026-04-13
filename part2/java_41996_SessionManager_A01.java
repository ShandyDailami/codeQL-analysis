import java.util.HashMap;
import java.util.Map;

public class java_41996_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41996_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session not found");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}