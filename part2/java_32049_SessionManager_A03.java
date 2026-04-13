import java.util.HashMap;
import java.util.Map;

public class java_32049_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_32049_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(userId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String userId;

        public java_32049_SessionManager_A03(String userId) {
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