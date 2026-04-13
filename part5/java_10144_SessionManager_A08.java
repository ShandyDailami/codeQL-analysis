import java.util.HashMap;
import java.util.Map;

public class java_10144_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_10144_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}