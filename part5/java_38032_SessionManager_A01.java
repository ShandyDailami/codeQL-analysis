import java.util.HashMap;

public class java_38032_SessionManager_A01 {
    // A simple model of a session
    public static class Session {
        public String id;

        public java_38032_SessionManager_A01(String id) {
            this.id = id;
        }
    }

    // The manager's map of sessions
    private HashMap<String, Session> sessions = new HashMap<>();

    // Create a new session
    public Session createSession(String sessionID) {
        Session session = new Session(sessionID);
        sessions.put(sessionID, session);
        return session;
    }

    // Get a session by its ID
    public Session getSession(String sessionID) {
        return sessions.get(sessionID);
    }

    // Check if a session exists
    public boolean sessionExists(String sessionID) {
        return sessions.containsKey(sessionID);
    }

    // Remove a session by its ID
    public void removeSession(String sessionID) {
        sessions.remove(sessionID);
    }
}