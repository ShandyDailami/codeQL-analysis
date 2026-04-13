import java.util.*;

public class java_14804_SessionManager_A01 {
    // Private member to hold sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_14804_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String id;
        private User user;

        public java_14804_SessionManager_A01(String id, User user) {
            this.id = id;
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_14804_SessionManager_A01(String username, String password) {
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

    // Method to create a new session
    public Session createSession(String id, User user) {
        sessions.put(id, new Session(id, user));
        return sessions.get(id);
    }

    // Method to get a session by id
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Method to remove a session by id
    public void removeSession(String id) {
        sessions.remove(id);
    }

    // Class for BrokenAccessControl security violation
    public static class BrokenAccessControlException extends Exception {
        public java_14804_SessionManager_A01(String message) {
            super(message);
        }
    }

    // Method to check access to a session
    public void checkAccess(String sessionId, User user) throws BrokenAccessControlException {
        Session session = getSession(sessionId);
        if (session == null || session.getUser() != user) {
            throw new BrokenAccessControlException("Access Denied!");
        }
    }
}