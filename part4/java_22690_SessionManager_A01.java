import java.util.HashMap;
import java.util.Map;

public class java_22690_SessionManager_A01 {
    // The hash map to store sessions
    private Map<String, Session> sessions;

    public java_22690_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_22690_SessionManager_A01(String id) {
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