import java.util.LinkedHashMap;
import java.util.Map;

public class java_14219_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_14219_SessionManager_A03() {
        sessions = new LinkedHashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, user);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;
        private String user;

        public java_14219_SessionManager_A03(String sessionId, String user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUser() {
            return user;
        }
    }
}