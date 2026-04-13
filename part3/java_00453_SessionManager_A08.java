import java.util.HashMap;
import java.util.Map;

public class java_00453_SessionManager_A08 {

    // A private instance of Map for holding user sessions
    private Map<String, Session> sessions;

    // The constructor initializes the sessions map
    public java_00453_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // A session represents a user's active browsing session
    public class Session {
        private String user;

        public java_00453_SessionManager_A08(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    // Function to create a new session for a user
    public Session createSession(String user) {
        Session session = new Session(user);
        sessions.put(user, session);
        return session;
    }

    // Function to destroy a session for a user
    public void destroySession(String user) {
        sessions.remove(user);
    }

    // Function to get a session for a user
    public Session getSession(String user) {
        return sessions.get(user);
    }

    // Demonstration of the integrity failure
    public void integrityFailure() {
        // Trying to get a session that doesn't exist
        Session session = getSession("unknown");
        if (session != null) {
            // Session exists, so it's a security violation
            System.out.println("Session exists for user " + session.getUser() + ". This is an integrity failure.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Creating a session for user "Alice"
        Session session = manager.createSession("Alice");

        // Demonstrating the integrity failure
        manager.integrityFailure();

        // Destroying the session for user "Alice"
        manager.destroySession("Alice");
    }
}