import java.util.HashMap;
import java.util.Map;

public class java_01812_SessionManager_A01 {
    // Creating a HashMap to store session objects.
    private Map<String, Session> sessionMap;

    // Session class.
    public class Session {
        private String sessionId;
        private User user;

        public java_01812_SessionManager_A01(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }
    }

    // User class.
    public class User {
        private String name;

        public java_01812_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // SessionManager constructor.
    public java_01812_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public Session createSession(String sessionId, User user) {
        Session session = new Session(sessionId, user);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}