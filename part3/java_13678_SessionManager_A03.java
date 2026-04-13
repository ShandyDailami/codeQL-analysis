import java.util.HashMap;

public class java_13678_SessionManager_A03 {

    // Define a private HashMap to hold the sessions
    private HashMap<String, Session> sessions;

    // Define a Session class
    public class Session {
        private String id;
        private User user;

        public java_13678_SessionManager_A03(String id, User user) {
            this.id = id;
            this.user = user;
        }

        // Getters and setters
        // ...
    }

    // Define a User class
    public class User {
        private String username;
        private String password;

        public java_13678_SessionManager_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters and setters
        // ...
    }

    // Constructor
    public java_13678_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to add a session
    public Session addSession(String username, String password) {
        User user = new User(username, password);
        String sessionId = user.username; // This is a very basic example. In a real-world application, you would want to generate a unique session ID for each user.
        Session session = new Session(sessionId, user);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }
}