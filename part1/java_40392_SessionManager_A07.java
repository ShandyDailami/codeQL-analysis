import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class java_40392_SessionManager_A07 {
    // In-memory storage for sessions
    private Map<String, Session> sessionMap = new HashMap<>();

    public void createSession(String userId) {
        Session session = new Session(userId);
        sessionMap.put(userId, session);
    }

    public void associateSession(String userId, Session session) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User " + userId + " has not created a session.");
        }
        session.associateWith(sessionMap.get(userId));
    }

    public void expireSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User " + userId + " has not created a session.");
        }
        sessionMap.get(userId).expire();
        sessionMap.remove(userId);
    }

    // Session class
    class Session {
        private String userId;
        private Date creationDate;
        private Date expirationDate;

        public java_40392_SessionManager_A07(String userId) {
            this.userId = userId;
            this.creationDate = new Date();
            this.expirationDate = new Date(this.creationDate.getTime() + 3600000L * 24 * 7); // 7 days
        }

        public void associateWith(Session session) {
            // Associating session is not security sensitive because it does not involve any sensitive data.
        }

        public void expire() {
            this.expirationDate = new Date();
        }

        public boolean isActive() {
            return new Date().before(this.expirationDate);
        }
    }
}