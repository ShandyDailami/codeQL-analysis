import java.util.HashMap;
import java.util.Map;

public class java_24324_SessionManager_A08 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_24324_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        // Check if the session id is already in use
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session ID already in use.";
        }

        // Otherwise, add the session to the map
        sessionMap.put(sessionId, "Session active");

        return "Session created with ID: " + sessionId;
    }

    // Destroy a session
    public String destroySession(String sessionId) {
        // Check if the session id is in the map
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID not found.";
        }

        // Otherwise, remove the session from the map
        sessionMap.remove(sessionId);

        return "Session destroyed with ID: " + sessionId;
    }

    // Check if a session is active
    public String checkSession(String sessionId) {
        // Check if the session id is in the map
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID not found.";
        }

        // Otherwise, return the status of the session
        return "Session found with ID: " + sessionId;
    }
}