import java.util.HashMap;
import java.util.Map;

public class java_16889_SessionManager_A08 {
    // Create a map to hold sessions
    private Map<String, Session> sessions;

    public java_16889_SessionManager_A08() {
        // Initialize the map
        sessions = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, Session session) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
        }

        // Check if session is already in the map
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }

        // Add the session to the map
        sessions.put(sessionId, session);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
       
        // Check if session is not in the map
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist");
        }

        // Remove the session from the map
        sessions.remove(sessionId);
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
        }

        // Check if session is not in the map
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist");
        }

        // Return the session
        return sessions.get(sessionId);
    }
}