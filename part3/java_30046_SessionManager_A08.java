import java.util.HashMap;
import java.util.Map;

public class java_30046_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_30046_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " already exists");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " does not exist");
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " does not exist");
        }
        sessions.remove(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_30046_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}