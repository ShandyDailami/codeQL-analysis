import java.util.HashMap;
import java.util.Map;

public class java_25360_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_25360_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String userId) {
        Session session = new Session();
        session.setUserId(userId);
        sessions.put(userId, session);
        return session;
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }

    public static class Session {
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}