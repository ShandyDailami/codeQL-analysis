import java.util.HashMap;
import java.util.Map;

public class java_15535_SessionManager_A03 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_15535_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if session ID already exists
        if (sessionMap.containsKey(sessionId)) {
            return null;
        }

        // Add session to map
        sessionMap.put(sessionId, sessionId);

        return sessionId;
    }

    // Method to get a session by its ID
    public String getSession(String sessionId) {
        // Return the session ID if it exists
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}