import java.util.HashMap;
import java.util.Map;

public class java_00714_SessionManager_A01 {
    // Private data structure for storing sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_00714_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for starting a new session
    public String startSession(String userId) {
        // Generate a unique session ID
        String sessionId = UUID.randomUUID().toString();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method for validating a session
    public String validateSession(String sessionId) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Return the user ID for the validated session
            return sessionMap.get(sessionId);
        } else {
            // Return null if the session ID is not valid
            return null;
        }
    }
}