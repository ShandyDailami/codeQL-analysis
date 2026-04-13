import java.util.HashMap;
import java.util.Map;

public class java_18732_SessionManager_A08 {

    // A map of all active sessions
    private Map<String, Session> sessions;

    // A map of all currently active users
    private Map<String, User> users;

    public java_18732_SessionManager_A08() {
        this.sessions = new HashMap<>();
        this.users = new HashMap<>();
    }

    // Method to create a new session for a user
    public String createSession(String userId) {
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            Session session = new Session(user);
            sessions.put(session.getId(), session);
            return session.getId();
        } else {
            throw new IllegalArgumentException("User does not exist: " + userId);
        }
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to check if a user is authenticated
    public boolean isUserAuthenticated(String sessionId) {
        if (isSessionActive(sessionId)) {
            Session session = sessions.get(sessionId);
            return session.isAuthenticated();
        } else {
            throw new IllegalArgumentException("Session does not exist: " + sessionId);
        }
    }

    // User and Session classes
    class User {
        private String id;
        private boolean authenticated;

        public java_18732_SessionManager_A08(String id) {
            this.id = id;
            this.authenticated = false;
        }

        public String getId() {
            return id;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }
    }

    class Session {
        private String id;
        private User user;
        private long expirationTime;

        public java_18732_SessionManager_A08(User user) {
            this.id = UUID.randomUUID().toString();
            this.user = user;
            this.expirationTime = System.currentTimeMillis() + 10000; // 10 second expiration
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public boolean isAuthenticated() {
            return user.isAuthenticated();
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }
    }
}