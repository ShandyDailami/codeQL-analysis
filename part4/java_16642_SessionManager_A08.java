import java.util.HashMap;
import java.util.Map;

public class java_16642_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_16642_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session found for id: " + sessionId);
        }
        return session;
    }

    public void deleteSession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new RuntimeException("No session found for id: " + sessionId);
        }
    }

    private class Session {
        private String id;

        public java_16642_SessionManager_A08(String id) {
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