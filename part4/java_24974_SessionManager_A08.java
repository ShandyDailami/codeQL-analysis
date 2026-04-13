import java.util.HashMap;
import java.util.Map;

public class java_24974_SessionManager_A08 {
    private Map<String, UserSession> sessions;

    public java_24974_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, UserSession userSession) {
        sessions.put(sessionId, userSession);
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class UserSession {
        private String userId;

        public java_24974_SessionManager_A08(String userId) {
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