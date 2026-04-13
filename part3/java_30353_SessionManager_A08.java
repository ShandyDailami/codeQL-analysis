import java.util.HashMap;
import java.util.Map;

public class java_30353_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_30353_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " already exists.");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session with id " + sessionId + " exists.");
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }
}