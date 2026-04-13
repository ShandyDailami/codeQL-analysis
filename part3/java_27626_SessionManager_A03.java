import java.util.concurrent.ConcurrentHashMap;

public class java_27626_SessionManager_A03 {
    private ConcurrentHashMap<String, Session> sessions;

    public java_27626_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            Session existingSession = sessions.putIfAbsent(sessionId, session);
            if (existingSession == null) {
                session = session;
            }
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_27626_SessionManager_A03(String sessionId) {
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