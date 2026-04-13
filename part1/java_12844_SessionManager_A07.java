import java.util.HashMap;

public class java_12844_SessionManager_A07 {
    private HashMap<String, Session> sessions;

    public java_12844_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session found: " + sessionId);
            return sessions.get(sessionId);
        } else {
            System.out.println("Creating new Session: " + sessionId);
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public class Session {
        private String sessionId;

        public java_12844_SessionManager_A07(String sessionId) {
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