import java.util.HashMap;

public class java_25613_SessionManager_A07 {
    private HashMap<String, Session> sessions;

    public java_25613_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("Session does not exist");
        }

        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("Session does not exist");
        }

        sessions.remove(sessionId);
    }
}