import java.util.HashMap;

public class java_25473_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_25473_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists");
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists");
        }
        sessions.remove(sessionId);
    }
}