import java.util.HashMap;
import java.util.Map;

public class java_22309_SessionManager_A03 {

    // Store all sessions in a map
    private Map<String, Session> sessions;

    public java_22309_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the given ID already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return sessionId;
    }

    // Get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the given ID exists.");
        }

        return sessions.get(sessionId);
    }

    // Destroy a session
    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the given ID exists.");
        }

        sessions.remove(sessionId);
    }

    // Session class
    private static class Session {
        private String id;

        public java_22309_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }
}