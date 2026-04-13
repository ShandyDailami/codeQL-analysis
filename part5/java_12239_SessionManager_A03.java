import java.util.HashMap;
import java.util.Map;

public class java_12239_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_12239_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with ID " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with ID " + sessionId);
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with ID " + sessionId);
        }
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_12239_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}