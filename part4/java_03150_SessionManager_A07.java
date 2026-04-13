import java.util.HashMap;

public class java_03150_SessionManager_A07 {
    // Create a HashMap to store the session information.
    private HashMap<String, Session> sessionMap;

    // Constructor to initialize the session map.
    public java_03150_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(Session session) {
        // Generate a unique session id.
        String sessionId = session.getId();
        // Store the session in the session map.
        sessionMap.put(sessionId, session);
        // Return the session id.
        return sessionId;
    }

    // Method to retrieve a session.
    public Session getSession(String sessionId) {
        // Return the session from the session map.
        return sessionMap.get(sessionId);
    }

    // Method to update a session.
    public void updateSession(String sessionId, Session session) {
        // Update the session in the session map.
        sessionMap.put(sessionId, session);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        // Remove the session from the session map.
        sessionMap.remove(sessionId);
    }
}