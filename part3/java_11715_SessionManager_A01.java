import java.util.HashMap;
import java.util.Map;

public class java_11715_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_11715_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists.");
        }
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists.");
        }
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists.");
        }
        return sessionMap.get(sessionId);
    }
}