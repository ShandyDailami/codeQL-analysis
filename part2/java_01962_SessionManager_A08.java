import java.util.HashMap;
import java.util.Map;

public class java_01962_SessionManager_A08 {
    // Define a HashMap to store session information
    private Map<String, String> sessionMap;

    // Constructor
    public java_01962_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            return "Error: Session ID is null or empty.";
        }

        // Check if userId is null or empty
        if (userId == null || userId.isEmpty()) {
            return "Error: User ID is null or empty.";
        }

        // Add session information to the session map
        sessionMap.put(sessionId, userId);

        return "Session created successfully.";
    }

    // Method to get the userId associated with a session
    public String getUserId(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            return "Error: Session ID is null or empty.";
        }

        // Retrieve userId from the session map
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            return "Error: Session ID is null or empty.";
        }

        // Remove session from the session map
        sessionMap.remove(sessionId);

        return "Session deleted successfully.";
    }
}