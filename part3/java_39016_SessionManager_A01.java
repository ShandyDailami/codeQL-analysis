import java.util.HashMap;

public class java_39016_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_39016_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }

        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.remove(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session with ID " + sessionId + " to destroy.");
        }
    }
}