import java.util.HashMap;
import java.util.Map;

public class java_00616_SessionManager_A07 {
    // Using a simple HashMap as the underlying data structure for the Session Manager
    private Map<String, String> sessionMap;

    public java_00616_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a secure session id
        String sessionId = generateSecureSessionId(userId);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            // If not, return null (indicating the session is invalid)
            return null;
        }

        // If the session id does exist, return the user id associated with it
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Remove the session id from the map
        sessionMap.remove(sessionId);
    }

    // Generate a secure session id based on the user id
    private String generateSecureSessionId(String userId) {
        // This is a simple implementation for demonstration purposes
        // In a real-world scenario, you would use more secure algorithms
        // and encrypt the user id to prevent replay attacks
        return userId;
    }
}