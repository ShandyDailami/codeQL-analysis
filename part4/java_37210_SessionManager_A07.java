import java.util.HashMap;
import java.util.Map;

public class java_37210_SessionManager_A07 {
    private Map<String, Session> sessions = new HashMap<>();

    public java_37210_SessionManager_A07() {
        // No-op constructor
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists: " + sessionId);
        }

        sessions.remove(sessionId);
    }

    private static class Session {
        private String id;

        public java_37210_SessionManager_A07(String id) {
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