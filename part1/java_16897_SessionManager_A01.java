import java.util.HashMap;
import java.util.Map;

public class java_16897_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_16897_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }

        Session session = new Session();
        session.setId(sessionId);
        sessions.put(sessionId, session);
    }

    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
        }

        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}