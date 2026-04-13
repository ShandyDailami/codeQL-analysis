import java.util.HashMap;
import java.util.Map;

public class java_36389_SessionManager_A03 {
    // Map to store sessions
    private Map<String, Session> sessions;

    public java_36389_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String sessionId;
        private User user;

        public java_36389_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_36389_SessionManager_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // Method to add a new session
    public Session addSession(String sessionId, String username, String password) {
        Session session = new Session(sessionId);
        session.setUser(new User(username, password));
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a user from a session
    public User getUserFromSession(String sessionId) {
        Session session = sessions.get(sessionId);
        return session != null ? session.getUser() : null;
    }
}