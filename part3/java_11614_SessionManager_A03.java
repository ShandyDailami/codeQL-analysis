import java.util.HashMap;
import java.util.Map;

public class java_11614_SessionManager_A03 {
    // A map to hold session objects. Key is session ID.
    private Map<String, Session> sessionMap;

    public java_11614_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessionMap.put(session.getId(), session);
        return session;
    }

    // Method to get a session given the session ID.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;
        private User user;

        public java_11614_SessionManager_A03(String id) {
            this.id = id;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public String getId() {
            return id;
        }
    }

    // User class
    public class User {
        private String id;

        public java_11614_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}