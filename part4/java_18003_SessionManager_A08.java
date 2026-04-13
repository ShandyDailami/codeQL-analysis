import java.util.HashMap;
import java.util.Map;

public class java_18003_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18003_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists for this user.");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No such session exists.");
        } else {
            return sessionMap.get(sessionId);
        }
    }

    public void removeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No such session exists.");
        } else {
            sessionMap.remove(sessionId);
        }
    }

    public void invalidateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No such session exists.");
        } else {
            sessionMap.remove(sessionId);
        }
    }
}