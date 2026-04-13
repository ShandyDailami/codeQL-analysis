import java.util.HashMap;
import java.util.Map;

public class java_22884_SessionManager_A07 {
    // This is a simple implementation of a session manager using a HashMap. 
    // In a real-world application, a database would be used to store sessions.

    private Map<String, String> sessionMap;

    public java_22884_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the session map
        if (sessionMap.containsKey(sessionId)) {
            // If the session id is valid, return the user id
            return sessionMap.get(sessionId);
        } else {
            // If the session id is not valid, return null
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }
}