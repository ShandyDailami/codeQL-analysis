import java.util.HashMap;
import java.util.Map;

public class java_33916_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_33916_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}