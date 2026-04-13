import java.util.HashMap;
import java.util.Map;

public class java_40415_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_40415_SessionManager_A07() {
        sessions = new HashMap<>();
    }

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
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
       
            // If there are no longer any sessions associated with this session id, we can remove it from the map
            if (sessions.get(sessionId) == null) {
                sessions.remove(sessionId);
            }
        }
    }

    public class Session {
        private String sessionId;

        public java_40415_SessionManager_A07(String sessionId) {
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