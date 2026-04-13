import java.util.HashMap;
import java.util.Map;

public class java_26743_SessionManager_A03 {
    // Using a HashMap as the session storage
    private Map<String, Session> sessions;

    // Session class with attributes
    public class Session {
        private String id;
        private User user;

        // Constructor, Getters and Setters
        public java_26743_SessionManager_A03(String id, User user) {
            this.id = id;
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // User class with attributes
    public class User {
        private String name;

        // Constructor, Getter and Setter
        public java_26743_SessionManager_A03(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Constructor
    public java_26743_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String userId) {
        // Here you can add logic to create a new session.
        // We just use a unique id for now.
        Session session = new Session(userId, new User(userId));
        sessions.put(userId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String userId) {
        // Here you can add logic to get a session.
        // We just return the session if it exists, otherwise null.
        return sessions.get(userId);
    }
}