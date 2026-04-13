import java.util.ArrayList;
import java.util.List;

public class java_20716_SessionManager_A01 {

    // a list to store active sessions
    private List<Session> sessions;

    // constructor
    public java_20716_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    // method to add a session
    public void addSession(Session session) {
        sessions.add(session);
    }

    // method to remove a session
    public void removeSession(Session session) {
        sessions.remove(session);
    }

    // method to check a session
    public boolean checkSession(Session session) {
        return sessions.contains(session);
    }

    // static inner class Session
    public static class Session {

        private String sessionId;
        private User user;

        // constructor
        public java_20716_SessionManager_A01(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        // getters and setters
        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        // method to check user's permissions
        public boolean hasPermission(Permission permission) {
            // This method is not real security-sensitive.
            // It's just a mock-up of the real implementation.
            // In a real-world scenario, permissions would be checked
            // in the context of the user's current session.
            return true;
        }
    }

    // static inner class User
    public static class User {

        private String username;

        // constructor
        public java_20716_SessionManager_A01(String username) {
            this.username = username;
        }

        // getter and setter
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    // static inner class Permission
    public static class Permission {

        private String name;

        // constructor
        public java_20716_SessionManager_A01(String name) {
            this.name = name;
        }

        // getter and setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}