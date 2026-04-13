import java.util.HashMap;
import java.util.Map;

public class java_24790_SessionManager_A01 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_24790_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if session already exists
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        }

        // Add session to the map
        sessionMap.put(sessionId, sessionId);
        return "Session created";
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        // Check if session exists
        if (!sessionMap.containsKey(sessionId)) {
            return "No session found";
        }

        // Return the session if it exists
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        // Check if session exists
        if (!sessionMap.containsKey(sessionId)) {
            return "No session found";
        }

        // Remove session from the map
        sessionMap.remove(sessionId);
        return "Session deleted";
    }
}