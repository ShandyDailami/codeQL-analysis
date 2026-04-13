import java.util.HashMap;
import java.util.Map;

public class java_40803_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_40803_SessionManager_A01() {
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
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists with id: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session exists with id: " + sessionId);
        }

        sessions.remove(sessionId);
    }

    public class Session {
        private String sessionId;

        public java_40803_SessionManager_A01(String sessionId) {
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