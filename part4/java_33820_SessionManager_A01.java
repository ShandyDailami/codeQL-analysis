import java.util.HashMap;
import java.util.Map;

public class java_33820_SessionManager_A01 {
    // A simple in-memory map for session storage.
    private Map<String, Session> sessions;

    public java_33820_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void putSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // A simple Session class for demonstration.
    public class Session {
        private String userId;

        public java_33820_SessionManager_A01(String userId) {
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