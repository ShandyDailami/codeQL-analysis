import java.util.HashMap;
import java.util.Map;

public class java_27436_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_27436_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    public Session getSession(String userId) {
        Session session = sessions.get(userId);
        if (session == null) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        return session;
    }

    public void closeSession(String userId) {
        Session session = sessions.get(userId);
        if (session == null) {
            throw new IllegalStateException("No session to close for user: " + userId);
        }
        sessions.remove(userId);
    }

    public static class Session {
        private String userId;

        public java_27436_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }
}