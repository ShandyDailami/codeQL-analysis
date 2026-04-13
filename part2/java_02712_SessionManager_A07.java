import java.util.HashMap;

public class java_02712_SessionManager_A07 {
    // private data structure to store sessions
    private HashMap<String, Session> sessions;

    // Constructor
    public java_02712_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String sessionId;
        private User user;

        public java_02712_SessionManager_A07(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_02712_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Method to create a new session
    public Session createSession(String sessionId, User user) {
        Session session = new Session(sessionId, user);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to validate a session
    public User validateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).getUser();
        } else {
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}