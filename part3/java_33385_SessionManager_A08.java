import java.util.HashMap;
import java.util.Map;

public class java_33385_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_33385_SessionManager_A08() {
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
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }

        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_33385_SessionManager_A08(String id) {
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