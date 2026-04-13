import java.util.HashMap;
import java.util.Map;

public class java_31921_SessionManager_A08 {
    // A simple in-memory representation of a session
    private class Session {
        private String id;
        private User user;

        public java_31921_SessionManager_A08(String id, User user) {
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

    // A simple user representation
    private class User {
        private String name;
        private String password;

        public java_31921_SessionManager_A08(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    // In-memory store of users and sessions
    private Map<String, User> userStore = new HashMap<>();
    private Map<String, Session> sessionStore = new HashMap<>();

    // Method to create a new session for a user
    public String createSession(String userName, String password) {
        // We're not actually checking the password here, but we'll pretend it's a secure check
        if (userStore.containsKey(userName) && userStore.get(userName).getPassword().equals(password)) {
            User user = userStore.get(userName);
            String sessionId = user.getName() + "-" + System.currentTimeMillis();
            sessionStore.put(sessionId, new Session(sessionId, user));
            return sessionId;
        } else {
            return null;
        }
    }

    // Method to get a user by a session
    public User getUser(String sessionId) {
        Session session = sessionStore.get(sessionId);
        return session != null ? session.getUser() : null;
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}