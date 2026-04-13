import java.util.HashMap;
import java.util.Map;

public class java_28634_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, Session> sessions;

    // Define a session
    public class Session {
        private String user;

        public java_28634_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    // Initialize the session manager
    public java_28634_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Create a session
    public Session createSession(String user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Session session = new Session(user);
        sessions.put(user, session);
        return session;
    }

    // Retrieve a session
    public Session getSession(String user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        return sessions.get(user);
    }

    // Destroy a session
    public void destroySession(String user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        sessions.remove(user);
    }
}