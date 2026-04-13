import java.util.HashMap;
import java.util.Map;

public class java_27214_SessionManager_A07 {
    // A map to hold the sessions. Each session is identified by a unique ID.
    private Map<String, Session> sessionMap;

    public java_27214_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // A session represents a user's ongoing interaction with the server.
    private class Session {
        private String id;
        private User user;

        public java_27214_SessionManager_A07(String id, User user) {
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

    // A user represents a user of the system.
    private class User {
        private String username;
        private String password;

        public java_27214_SessionManager_A07(String username, String password) {
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

    // This method creates a new session for a user.
    public Session createSession(String username, String password) {
        // The username and password are not checked for security reasons.
        // In a real system, they should be checked against a secure database.
        User user = new User(username, password);
        String id = user.getUsername();
        Session session = new Session(id, user);
        sessionMap.put(id, session);
        return session;
    }

    // This method logs in a user.
    public Session login(String username, String password) {
        // The username and password are not checked for security reasons.
        // In a real system, they should be checked against a secure database.
        User user = new User(username, password);
        Session session = sessionMap.get(user.getUsername());
        if (session == null || !session.getUser().getPassword().equals(user.getPassword())) {
            // The login failed.
            return null;
        }
        return session;
    }

    // This method logs out a user.
    public void logout(Session session) {
        sessionMap.remove(session.getUser().getUsername());
    }
}