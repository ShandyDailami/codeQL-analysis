import java.util.HashMap;
import java.util.Map;

public class java_31516_SessionManager_A03 {
    // Create a hash map to store user sessions.
    private Map<String, String> userSessions;

    public java_31516_SessionManager_A03() {
        userSessions = new HashMap<>();
    }

    // Method to create a new session for a user.
    public String createSession(String userId) {
        // Add the user id to the map and return a new session id.
        userSessions.put(userId, generateSessionId());
        return userSessions.get(userId);
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId, String userId) {
        // Check if the session id matches the user id.
        return userSessions.get(userId).equals(sessionId);
    }

    // Method to generate a new session id.
    private String generateSessionId() {
        // Here you would typically use a UUID or some other secure method to generate a unique id.
        // For the sake of this example, we'll just return a static id.
        return "sessionId";
    }
}