import java.util.HashMap;
import java.util.Map;

public class java_09976_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09976_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // Check if the sessionId is already used
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID " + sessionId + " already in use, please use a new session ID.");
            return;
        }

        // Check if the userId is not valid (for example, not exist in the database)
        if (!isValidUserId(userId)) {
            System.out.println("Invalid user ID " + userId + ".");
            return;
        }

        // Create a new session
        sessionMap.put(sessionId, userId);
        System.out.println("Session " + sessionId + " started for user " + userId + ".");
    }

    public void endSession(String sessionId) {
        // Check if the sessionId exists
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session ID " + sessionId + " found.");
            return;
        }

        // Remove the session from the map
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended.");
    }

    // Other helper methods to validate user IDs
    private boolean isValidUserId(String userId) {
        // Here you could implement the actual validation logic
        // For now, we just return true to simulate a valid user ID
        return true;
    }
}