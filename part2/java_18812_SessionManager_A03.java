import java.util.HashMap;
import java.util.Map;

public class java_18812_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_18812_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exists with id: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exists with id: " + sessionId);
        }
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_18812_SessionManager_A03(String id) {
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