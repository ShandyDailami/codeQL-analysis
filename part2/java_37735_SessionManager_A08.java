import java.util.*;

public class java_37735_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_37735_SessionManager_A08() {
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

    public Session getSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }

        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }

        sessions.remove(userId);
    }

    public static class Session {

        private String userId;
        private Date createdAt;

        public java_37735_SessionManager_A08(String userId) {
            this.userId = userId;
            this.createdAt = new Date();
        }

        public String getUserId() {
            return userId;
        }

        public Date getCreatedAt() {
            return createdAt;
        }
    }
}