import java.util.HashMap;
import java.util.Map;

public class java_23855_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_23855_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String id) {
        if (sessions.containsKey(id)) {
            return sessions.get(id);
        } else {
            Session session = new Session(id);
            sessions.put(id, session);
            return session;
        }
    }

    public void closeSession(String id) {
        if (sessions.containsKey(id)) {
            sessions.remove(id);
            throw new SecurityException("Session closed unexpectedly");
        }
    }

    private class Session {

        private String id;

        public java_23855_SessionManager_A08(String id) {
            this.id = id;
        }

        public void close() {
            SessionManager.this.closeSession(this.id);
        }
    }
}