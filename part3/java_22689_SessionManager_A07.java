import java.util.HashMap;
import java.util.Map;

public class java_22689_SessionManager_A07 {

    private Map<String, Session> sessions;

    public java_22689_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void invalidateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isValid()) {
            sessions.remove(sessionId);
        }
    }

    private class Session {

        private String sessionId;
        private boolean valid;

        public java_22689_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
            this.valid = true;
        }

        public String getSessionId() {
            return sessionId;
        }

        public boolean isValid() {
            return valid;
        }

        public void setInvalid() {
            valid = false;
        }
    }
}