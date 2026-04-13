import java.util.HashMap;
import java.util.Map;

public class java_08841_SessionManager_A08 {

    // Map to store sessions
    private Map<String, Session> sessions;

    // Session class
    public class Session {
        private String sessionId;
        private User user;

        public java_08841_SessionManager_A08(String sessionId, User user) {
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

    // User class
    public class User {
        private String username;

        public java_08841_SessionManager_A08(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    // Constructor
    public java_08841_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId, User user) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with the id: " + sessionId);
        }
        Session session = new Session(sessionId, user);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with the id: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with the id: " + sessionId);
        }
        sessions.remove(sessionId);
    }
}