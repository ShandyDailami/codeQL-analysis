import java.util.HashMap;
import java.util.Map;

public class java_15659_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_15659_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session startSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessions.containsKey(userId);
    }

    public static class Session {
        private String userId;

        public java_15659_SessionManager_A01(String userId) {
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