import java.util.HashMap;
import java.util.Map;

public class java_18899_SessionManager_A08 {

    // Store of sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_18899_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_18899_SessionManager_A08(String id) {
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