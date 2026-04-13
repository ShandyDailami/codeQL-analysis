import java.util.HashMap;
import java.util.Map;

public class java_33564_SessionManager_A07 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_33564_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public String addSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists!";
        }
        // Add the sessionId to the HashMap
        sessionMap.put(sessionId, sessionId);
        return "Session added successfully!";
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if sessionId is in use
        if (!sessionMap.containsKey(sessionId)) {
            return "Session not found!";
        }
        // Return a message indicating the sessionId is valid
        return "Session is valid!";
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        // Check if sessionId is in use
        if (!sessionMap.containsKey(sessionId)) {
            return "Session not found!";
        }
        // Remove the sessionId from the HashMap
        sessionMap.remove(sessionId);
        return "Session removed successfully!";
    }
}