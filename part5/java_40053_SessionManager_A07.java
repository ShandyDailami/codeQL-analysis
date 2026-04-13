import java.util.HashMap;
import java.util.Map;

public class java_40053_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_40053_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a random session ID
        String sessionId = generateRandomSessionId();

        // Store the session ID and user ID in the map
        sessions.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Check if the session ID is valid and related to a user
        if (isValidSession(sessionId)) {
            // Return the user ID
            return sessions.get(sessionId);
        } else {
            // Throw an exception if the session ID is not valid
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void removeSession(String sessionId) {
        // Remove the session ID from the map
        sessions.remove(sessionId);
    }

    // Private methods to implement session validation
    private boolean isValidSession(String sessionId) {
        // Implement the validation logic here
        // For example, check if the session ID is in the map and not null
        return sessionId != null && sessions.containsKey(sessionId);
    }

    private String generateRandomSessionId() {
        // Implement the generation of a random session ID here
        // This could be as simple as a UUID, or a complex one that incorporates user information
        return UUID.randomUUID().toString();
    }
}