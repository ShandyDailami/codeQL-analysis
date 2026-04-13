import java.util.HashMap;
import java.util.Map;

public class java_32441_SessionManager_A01 {

    // A map to store sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_32441_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists for the given ID");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to retrieve a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session found for the given ID");
        }

        return sessions.get(sessionId);
    }

    // Session class
    class Session {
        private String id;

        // Constructor
        Session(String id) {
            this.id = id;
        }

        // Getter for id
        public String getId() {
            return id;
        }

        // Method to close a session
        public void closeSession() {
            sessions.remove(id);
        }
    }
}