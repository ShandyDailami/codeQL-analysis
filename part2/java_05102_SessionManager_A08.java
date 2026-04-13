import java.util.HashMap;
import java.util.Map;

public class java_05102_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05102_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }
        sessionMap.put(sessionId, userId);
        return "Session created";
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exists");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exists");
        }
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                sessionMap.remove(entry.getKey());
            }
        }
    }

    public void invalidateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exists");
        }
        sessionMap.put(sessionId, null);
    }
}