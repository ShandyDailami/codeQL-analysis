import java.util.HashMap;
import java.util.Map;

public class java_26323_SessionManager_A07 {
    // Define a Map to hold the user sessions
    private Map<String, String> userSessions;

    // Constructor
    public java_26323_SessionManager_A07() {
        userSessions = new HashMap<>();
    }

    // Method to create a new session for a user
    public String createSession(String userId) {
        // Generate a random session id
        String sessionId = String.valueOf((int) (Math.random() * 10000000));

        // Store the session id in the map
        userSessions.put(sessionId, userId);

        return sessionId;
    }

    // Method to check if a session is valid and belongs to a user
    public boolean isValidSession(String sessionId, String userId) {
        // If the session id and user id match in the map, return true
        return (userSessions.get(sessionId).equals(userId));
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Remove the session id from the map
        userSessions.remove(sessionId);
    }
}