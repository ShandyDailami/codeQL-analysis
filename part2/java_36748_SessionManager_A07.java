import java.util.HashMap;
import java.util.Map;

public class java_36748_SessionManager_A07 {

    // Map to hold sessions
    private Map<String, Session> sessions;

    public java_36748_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with ID: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Destroy a session
    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists with ID: " + sessionId);
        }
        sessions.remove(sessionId);
    }

    // Session class
    public class Session {

        private String id;

        public java_36748_SessionManager_A07(String id) {
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