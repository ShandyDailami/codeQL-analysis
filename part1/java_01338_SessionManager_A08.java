import java.util.HashMap;

public class java_01338_SessionManager_A08 {
    // Store user sessions. Key is User object, value is Session object.
    private HashMap<User, Session> sessions;

    public java_01338_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a new session.
    public Session createSession(User user) {
        Session session = new Session(user);
        sessions.put(user, session);
        return session;
    }

    // Check the integrity of a session.
    public boolean checkSessionIntegrity(Session session) {
        return sessions.containsValue(session);
    }

    // A simple session class.
    public class Session {
        private User user;

        public java_01338_SessionManager_A08(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // A simple user class.
    public class User {
        private String name;

        public java_01338_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}