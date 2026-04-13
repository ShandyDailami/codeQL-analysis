import java.util.HashMap;
import java.util.Map;

public class java_39062_SessionManager_A08 {
    // Create a map to hold the sessions.
    private Map<String, Session> sessions;

    public java_39062_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a new session.
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with id " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Get a session.
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new IllegalArgumentException("No session with id " + sessionId + " exists.");
        }

        return session;
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        Session session = sessions.remove(sessionId);

        if (session == null) {
            throw new IllegalArgumentException("No session with id " + sessionId + " exists.");
        }
    }
}