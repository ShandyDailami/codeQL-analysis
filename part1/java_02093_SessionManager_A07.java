import java.util.HashMap;
import java.util.Map;

public class java_02093_SessionManager_A07 {
    private Map<String, UserSession> sessionMap;

    public java_02093_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return "Error: Session already exists for user " + userId;
        }

        UserSession session = new UserSession(userId, true);
        sessionMap.put(userId, session);

        return "Success: Session created for user " + userId;
    }

    public String endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            return "Error: Session does not exist for user " + userId;
        }

        UserSession session = sessionMap.get(userId);
        session.setActive(false);

        return "Success: Session ended for user " + userId;
    }

    public UserSession getSession(String userId) {
        return sessionMap.get(userId);
    }

    public class UserSession {
        private String userId;
        private boolean active;

        public java_02093_SessionManager_A07(String userId, boolean active) {
            this.userId = userId;
            this.active = active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public boolean isActive() {
            return active;
        }

        public String getUserId() {
            return userId;
        }
    }
}