import java.util.HashMap;
import java.util.Map;

public class java_04721_SessionManager_A08 {

    // Session storage
    private Map<String, Session> sessions;

    public java_04721_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Session object
    public class Session {
        private String sessionId;
        private User user;

        public java_04721_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    // User object
    public class User {
        private String name;

        public java_04721_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Create a new session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session already exists!";
        } else {
            sessions.put(sessionId, new Session(sessionId));
            return "Session created successfully!";
        }
    }

    // Set user in session
    public String setUserInSession(String sessionId, String userName) {
        if (sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            session.setUser(new User(userName));
            return "User set in session successfully!";
        } else {
            return "Session does not exist!";
        }
    }

    // Get user from session
    public String getUserFromSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            return "User name: " + session.getUser().getName();
        } else {
            return "Session does not exist!";
        }
    }
}