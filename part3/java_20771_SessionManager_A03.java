import java.util.HashMap;
import java.util.Map;

public class java_20771_SessionManager_A03 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_20771_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Validate the sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            return "Session ID cannot be null or empty";
        }
        // If the sessionId is already in use, return an error
        if (sessionMap.containsKey(sessionId)) {
            return "Session ID is already in use";
        }
        // Otherwise, add the sessionId to the map and return a success message
        sessionMap.put(sessionId, "Session data");
        return "Session created successfully";
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        // Validate the sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            return "Session ID cannot be null or empty";
        }
        // If the sessionId is not in the map, return an error
        if (!sessionMap.containsKey(sessionId)) {
            return "Session ID is not found";
        }
        // Otherwise, return the session data
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        // Validate the sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            return "Session ID cannot be null or empty";
        }
        // If the sessionId is not in the map, return an error
        if (!sessionMap.containsKey(sessionId)) {
            return "Session ID is not found";
        }
        // Otherwise, remove the sessionId from the map and return a success message
        sessionMap.remove(sessionId);
        return "Session deleted successfully";
    }
}