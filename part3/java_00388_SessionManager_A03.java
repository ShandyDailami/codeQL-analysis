import java.util.HashMap;
import java.util.Map;

public class java_00388_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_00388_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, new Session(userId));
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public class Session {
        private String userId;
        private boolean isLoggedIn;

        public java_00388_SessionManager_A03(String userId) {
            this.userId = userId;
            isLoggedIn = true; // Assume all sessions are logged in
        }

        public String getUserId() {
            return userId;
        }

        public boolean isLoggedIn() {
            return isLoggedIn;
        }

        public void logout() {
            isLoggedIn = false;
        }
    }
}