import java.util.HashMap;

public class java_11680_SessionManager_A01 {
    private HashMap<String, Session> sessionMap;

    public java_11680_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;

        public java_11680_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void invalidate() {
            // Invalidate the session by closing it
            SessionManager.this.closeSession(sessionId);
        }
    }
}