import java.util.HashMap;
import java.util.Map;

public class java_33858_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33858_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist");
        }
        sessionMap.remove(sessionId);
    }

    public void breakAccessControl(String sessionId, String newUserId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist");
        }
        String oldUserId = sessionMap.get(sessionId);
        sessionMap.put(sessionId, newUserId);
        // Access control broken here: sessionMap.remove(sessionId);
    }
}