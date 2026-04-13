import java.util.HashMap;
import java.util.Map;

public class java_34975_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_34975_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.put(session.getSessionId(), session);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean authenticate(String sessionId, String password) {
        Session session = sessions.get(sessionId);
        return session != null && session.getPassword().equals(password);
    }

    public static class Session {
        private String sessionId;
        private String password;

        public java_34975_SessionManager_A01(String sessionId, String password) {
            this.sessionId = sessionId;
            this.password = password;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}