import java.util.HashMap;
import java.util.Map;

public class java_17865_SessionManager_A03 {
    // Using a HashMap as a session storage.
    private Map<String, String> sessionMap;

    public java_17865_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        // Check if the session ID is already in use.
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session ID already in use.";
        }

        // If not, add the session ID to the map and return a success message.
        sessionMap.put(sessionId, "Session data for " + sessionId);
        return "Success: Session ID created.";
    }

    // Method to retrieve data for a session.
    public String getSessionData(String sessionId) {
        // Check if the session ID exists in the map.
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID does not exist.";
        }

        // If it exists, return the session data.
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public String removeSession(String sessionId) {
        // Check if the session ID exists in the map.
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID does not exist.";
        }

        // If it exists, remove the session ID from the map and return a success message.
        sessionMap.remove(sessionId);
        return "Success: Session ID removed.";
    }
}