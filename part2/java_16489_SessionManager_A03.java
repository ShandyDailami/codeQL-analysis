import java.util.HashMap;
import java.util.Map;

public class java_16489_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_16489_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user");
        }
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user");
        }
        sessionMap.remove(userId);
    }

    public void validateSession(String userId, String sessionId) {
        String existingSessionId = sessionMap.get(userId);
        if (existingSessionId == null || !existingSessionId.equals(sessionId)) {
            throw new IllegalStateException("Invalid session");
        }
    }
}