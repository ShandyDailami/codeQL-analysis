import java.util.HashMap;

public class java_20816_SessionManager_A01 {
    // Using a HashMap for storing sessions
    private HashMap<String, Session> sessions;

    public java_20816_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Session session) {
        // Generate a unique session ID
        String sessionID = session.getSessionID();

        // Store the session in the HashMap
        sessions.put(sessionID, session);

        return sessionID;
    }

    // Method to get a session
    public Session getSession(String sessionID) {
        // Get the session from the HashMap
        return sessions.get(sessionID);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionID) {
        // Remove the session from the HashMap
        sessions.remove(sessionID);
    }
}

// Session class
public class Session {
    private String sessionID;

    // Constructor
    public java_20816_SessionManager_A01(String sessionID) {
        this.sessionID = sessionID;
    }

    // Getters and setters
    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}