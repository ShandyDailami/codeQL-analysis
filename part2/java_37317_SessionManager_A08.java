import java.util.HashMap;
import java.util.Map;

public class java_37317_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_37317_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    // Session class not shown for brevity
}