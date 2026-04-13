import java.util.HashMap;
import java.util.Map;

public class java_08788_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_08788_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public void openSession(String userId) {
        if (!sessions.containsKey(userId)) {
            sessions.put(userId, new Session(userId));
        }
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public void closeSession(String userId) {
        sessions.remove(userId);
    }

    private class Session {
        private String userId;

        public java_08788_SessionManager_A03(String userId) {
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