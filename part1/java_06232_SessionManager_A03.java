import java.util.HashMap;
import java.util.Map;

public class java_06232_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_06232_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with ID: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_06232_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Session ID cannot be null or empty");
            }
            this.id = id;
        }
    }
}