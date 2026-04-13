import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_16111_SessionManager_A01 {

    // Define a ConcurrentHashMap to store sessions
    private final Map<String, Session> sessions;

    // The SessionManager constructor
    public java_16111_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new RuntimeException("No session found with id: " + sessionId);
        }

        return session;
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    public class Session {

        private final String id;

        // Session constructor
        public java_16111_SessionManager_A01(String id) {
            this.id = id;
        }

        // Getter for session id
        public String getId() {
            return id;
        }
    }
}