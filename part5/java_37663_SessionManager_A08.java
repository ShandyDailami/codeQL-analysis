import java.util.HashMap;
import java.util.Map;

public class java_37663_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37663_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        sessionMap.put(userId, sessionId);
    }

    public String getSessionId(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        sessionMap.remove(userId);
    }

    public void invalidateSession(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }
}