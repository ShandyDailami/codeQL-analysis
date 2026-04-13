import java.util.HashMap;

public class java_27378_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_27378_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_27378_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}