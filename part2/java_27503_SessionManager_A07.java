import java.util.HashMap;
import java.util.Map;

public class java_27503_SessionManager_A07 {
    // A simple in-memory storage for sessions.
    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void invalidateSession(String sessionId) {
        Session session = getSession(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    public static class Session {
        private String sessionId;

        public java_27503_SessionManager_A07(String sessionId) {
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