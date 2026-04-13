import java.util.HashMap;
import java.util.Map;

public class java_21904_SessionManager_A07 {

    // HashMap for storing user session information
    private Map<String, String> sessionInfo = new HashMap<>();

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a session id
        String sessionId = UUID.randomUUID().toString();
        // Store the session id and user id in the session information map
        sessionInfo.put(sessionId, userId);
        // Return the session id
        return sessionId;
    }

    // Method to get the user id from a session
    public String getUserIdFromSession(String sessionId) {
        // Check if the session id is in the session information map
        if (sessionInfo.containsKey(sessionId)) {
            // Return the user id from the session information map
            return sessionInfo.get(sessionId);
        } else {
            // Return null if the session id is not in the map
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Check if the session id is in the session information map
        if (sessionInfo.containsKey(sessionId)) {
            // Remove the session id from the session information map
            sessionInfo.remove(sessionId);
        }
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Check if the session id is in the session information map
        return sessionInfo.containsKey(sessionId);
    }
}