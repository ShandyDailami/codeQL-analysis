import java.util.HashMap;

public class java_13076_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, Session> sessions;

    public java_13076_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession() {
        Session session = new Session();
        // Generate a unique identifier for the session
        String identifier = "SESSION_" + System.currentTimeMillis();
        session.setIdentifier(identifier);
        sessions.put(identifier, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String identifier) {
        return sessions.get(identifier);
    }

    // Method to close a session
    public void closeSession(String identifier) {
        Session session = sessions.get(identifier);
        if (session != null) {
            sessions.remove(identifier);
            session.close();
        }
    }
}