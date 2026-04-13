import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_22450_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_22450_SessionManager_A07() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessions.get(sessionId);
    }

    public void createSession(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }

        sessions.put(session.getId(), session);
    }

    public void updateSession(Session session) {
        if (session == null || session.getId() == null || session.getId().isEmpty()) {
            throw new IllegalArgumentException("Session cannot be null or its ID cannot be null or empty");
        }

        sessions.put(session.getId(), session);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessions.remove(sessionId);
    }

    // Inner Session class
    public class Session {
        private String id;

        public java_22450_SessionManager_A07(String id) {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Session ID cannot be null or empty");
            }

            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}