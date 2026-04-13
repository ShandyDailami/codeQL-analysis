import java.util.HashMap;
import java.util.Map;

public class java_18964_SessionManager_A07 {
    // Create a map to store sessions.
    private Map<String, Session> sessionMap = new HashMap<>();

    // Session class.
    public class Session {
        private String id;
        private User user;

        public java_18964_SessionManager_A07(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    // User class.
    public class User {
        private String name;

        public java_18964_SessionManager_A07(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Create a new session.
    public Session createSession(String userName) {
        User user = new User(userName);
        Session session = new Session(userName);
        session.setUser(user);
        sessionMap.put(userName, session);
        return session;
    }

    // Get a session.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // End a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}