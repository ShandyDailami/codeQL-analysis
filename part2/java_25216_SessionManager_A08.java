import java.util.HashMap;
import java.util.Map;

public class java_25216_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_25216_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new RuntimeException("Session not found with id: " + sessionId);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new RuntimeException("Session not found to close with id: " + sessionId);
        }
    }

    private class Session {
        private String id;
        private Map<String, Object> attributes;

        public java_25216_SessionManager_A08(String id) {
            this.id = id;
            this.attributes = new HashMap<>();
        }

        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        public Object getAttribute(String name) {
            return attributes.get(name);
        }
    }
}