import java.util.HashMap;

public class java_26903_SessionManager_A07 {
    private HashMap<String, Session> sessions;

    public java_26903_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_26903_SessionManager_A07(String sessionId) {
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