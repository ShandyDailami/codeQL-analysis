import java.util.HashMap;

public class java_34951_SessionManager_A07 {
    private HashMap<String, Session> sessionMap;

    public java_34951_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(Session session) {
        sessionMap.put(session.getSessionId(), session);
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_34951_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}