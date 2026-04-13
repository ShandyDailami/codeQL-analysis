import java.util.HashMap;
import java.util.Map;

public class java_27782_SessionManager_A03 {
    // A map to store sessions
    private Map<String, Session> sessions;

    public java_27782_SessionManager_A03() {
        // Initialize the sessions map
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists for id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session by id
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist for id: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    // Implementation of Session class (this is a placeholder, not really session)
    private class Session {
        private String id;

        public java_27782_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}