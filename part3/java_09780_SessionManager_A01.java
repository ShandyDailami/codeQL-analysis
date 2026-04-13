import java.util.HashMap;
import java.util.Map;

public class java_09780_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09780_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists.");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }
        sessionMap.remove(sessionId);
    }
}