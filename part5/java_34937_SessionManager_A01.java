import java.util.HashMap;
import java.util.Map;

public class java_34937_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34937_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session found with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session found with id: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }
}