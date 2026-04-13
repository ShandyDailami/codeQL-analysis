import java.util.HashMap;
import java.util.Map;

public class java_14405_SessionManager_A03 {

    // A map to store sessions
    private Map<String, Session> sessions;

    public java_14405_SessionManager_A03() {
        // Initialize the sessions map
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessions.containsKey(sessionId)) {
            return "Session already exists";
        }
        // Create a new session and add it to the map
        sessions.put(sessionId, new Session(sessionId));
        return "Session created";
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Get the session from the map
        return sessions.get(sessionId);
    }

    // Method to close a session
    public String closeSession(String sessionId) {
        // Check if sessionId is in use
        if (!sessions.containsKey(sessionId)) {
            return "Session does not exist";
        }
        // Close the session and remove it from the map
        sessions.get(sessionId).close();
        sessions.remove(sessionId);
        return "Session closed";
    }
}

class Session {
    private String sessionId;

    public java_14405_SessionManager_A03(String sessionId) {
        this.sessionId = sessionId;
    }

    // Method to close the session
    public void close() {
        // Close the session (e.g., remove it from memory)
    }
}