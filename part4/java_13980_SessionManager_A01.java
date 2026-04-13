import java.util.HashMap;
import java.util.Map;

public class java_13980_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_13980_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String userId;

        public java_13980_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}