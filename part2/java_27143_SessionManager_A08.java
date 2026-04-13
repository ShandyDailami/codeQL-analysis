import java.util.LinkedList;

public class java_27143_SessionManager_A08 {
    // LinkedList to store sessions
    private LinkedList<Session> sessions = new LinkedList<>();

    // Maximum number of sessions allowed
    private static final int MAX_SESSIONS = 10;

    // Singleton instance
    private static SessionManager instance = null;

    // Private constructor to prevent instantiation
    private java_27143_SessionManager_A08() {}

    // Get the instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Open a new session
    public Session openSession() {
        // If there are already MAX_SESSIONS sessions open, remove the first one
        if (sessions.size() == MAX_SESSIONS) {
            sessions.removeFirst();
        }

        // Create a new session and add it to the list of sessions
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    // Close a session
    public void closeSession(Session session) {
        // Remove the session from the list of sessions
        sessions.remove(session);
    }
}

// Session class represents a database session
class Session {}