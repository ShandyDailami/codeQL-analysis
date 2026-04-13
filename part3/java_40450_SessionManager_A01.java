import java.util.HashMap;
import java.util.Map;

public class java_40450_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_40450_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }
        sessions.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist");
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_40450_SessionManager_A01(String id) {
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