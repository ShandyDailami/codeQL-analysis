import java.util.HashMap;
import java.util.Map;

public class java_36221_SessionManager_A08 {
    // A map to store sessions.
    private Map<String, String> sessionMap;

    public java_36221_SessionManager_A08() {
        // Initialize the session map.
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        // Check if the session id is already in the map.
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists.";
        }

        // Otherwise, add the session id to the map and return a success message.
        sessionMap.put(sessionId, "Session created.");
        return "Session created.";
    }

    // Method to retrieve the data for a session.
    public String getSessionData(String sessionId) {
        // Check if the session id is in the map.
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session does not exist.";
        }

        // Otherwise, return the session data.
        return sessionMap.get(sessionId);
    }

    // Method to delete a session.
    public String deleteSession(String sessionId) {
        // Check if the session id is in the map.
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session does not exist.";
        }

        // Otherwise, remove the session id from the map and return a success message.
        sessionMap.remove(sessionId);
        return "Session deleted.";
    }
}