import java.util.HashSet;
import java.util.Set;

public class java_15380_SessionManager_A08 {
    // Store sessions in a set
    private Set<Session> sessions;

    public java_15380_SessionManager_A08() {
        sessions = new HashSet<>();
    }

    // Session class
    public class Session {
        private String id;
        private User user;

        public java_15380_SessionManager_A08(String id) {
            this.id = id;
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

        public java_15380_SessionManager_A08(String username, String password) {
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
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.add(session);
        return session;
    }

    // Method to check if a session exists
    public Session getSession(String id) {
        for (Session session : sessions) {
            if (session.id.equals(id)) {
                return session;
            }
        }
        return null;
    }

    // Method to check if a session exists for a user
    public Session getSessionByUser(User user) {
        for (Session session : sessions) {
            if (session.getUser().equals(user)) {
                return session;
            }
        }
        return null;
    }

    // Method to check if a user is authenticated
    public boolean isAuthenticated(String id, User user) {
        Session session = getSession(id);
        if (session != null) {
            return session.getUser().equals(user);
        }
        return false;
    }

    // Method to check if a user is authenticated
    public boolean isAuthenticated(User user) {
        for (Session session : sessions) {
            if (session.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    // Method to remove a session
    public void removeSession(String id) {
        sessions.removeIf(session -> session.id.equals(id));
    }

    // Method to remove a session for a user
    public void removeSessionByUser(User user) {
        sessions.removeIf(session -> session.getUser().equals(user));
    }
}