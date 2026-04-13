import java.util.HashMap;
import java.util.Map;

public class java_18261_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_18261_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new RuntimeException("Invalid session id");
        }
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}