import java.util.HashMap;
import java.util.Map;

public class java_40781_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_40781_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }

        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }

        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_40781_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}