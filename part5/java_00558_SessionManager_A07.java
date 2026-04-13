import java.util.HashMap;
import java.util.Map;

public class java_00558_SessionManager_A07 {

    private Map<String, Session> sessions;

    public java_00558_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    public void destroySession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
       
        }
        sessions.remove(userId);
    }

    public class Session {
        private String userId;

        public java_00558_SessionManager_A07(String userId) {
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