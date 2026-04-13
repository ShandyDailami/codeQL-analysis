import java.util.HashMap;
import java.util.Map;

public class java_15864_SessionManager_A01 {
    // In-memory storage for sessions.
    private Map<String, Session> sessions;

    public java_15864_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String id;
        private User user;

        public java_15864_SessionManager_A01(String id, User user) {
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

        public java_15864_SessionManager_A01(String username, String password) {
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
    public Session createSession(String username, String password) {
        User user = new User(username, password);
        String id = user.getUsername() + "-" + user.getPassword();
        Session session = new Session(id, user);
        sessions.put(id, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Method to validate a session
    public boolean validateSession(String id, String password) {
        Session session = sessions.get(id);
        if (session != null) {
            return session.getUser().getPassword().equals(password);
        }
        return false;
    }
}