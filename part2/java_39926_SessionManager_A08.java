import java.util.HashMap;
import java.util.Map;

public class java_39926_SessionManager_A08 {

    // Data structure to store sessions
    private Map<String, Session> sessions = new HashMap<>();

    // Session class
    public class Session {

        private String id;
        private User user;

        public java_39926_SessionManager_A08(String id, User user) {
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

        private String name;

        public java_39926_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Method to create a session
    public Session createSession(String userName) {
        User user = new User(userName);
        String id = "session_id_" + userName;
        Session session = new Session(id, user);
        sessions.put(id, session);
        return session;
    }

    // Method to get the session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to validate a session
    public User validateSession(String sessionId) {
        Session session = getSession(sessionId);
        if (session == null) {
            throw new SecurityException("Invalid session id");
        }
        return session.getUser();
    }
}