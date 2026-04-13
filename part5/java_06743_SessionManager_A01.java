import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_06743_SessionManager_A01 {

    private Map<String, Session> sessions; // A map to store the sessions

    public java_06743_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session id
        Session session = new Session(user, sessionId);
        sessions.put(sessionId, session); // Store the session in the map
        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    private class Session {
        private User user;
        private String sessionId;

        public java_06743_SessionManager_A01(User user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        public User getUser() {
            return user;
        }

        public String getSessionId() {
            return sessionId;
        }
    }

    // User class
    private class User {
        private String username;

        public java_06743_SessionManager_A01(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}