import java.util.HashMap;
import java.util.Map;

public class java_23668_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_23668_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new AuthFailureException("Session not found");
        }
    }
}