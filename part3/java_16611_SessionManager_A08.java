import java.util.HashMap;
import java.util.Map;

public class java_16611_SessionManager_A08 {
    // Using a HashMap to store sessions
    private Map<String, String> sessions;

    // Constructor
    public java_16611_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Sensitive operation: Checking if the session exists and if the user is validated
        if (sessions.containsKey(sessionId)) {
            String userId = sessions.get(sessionId);
            // If user is validated, return userId
            return userId;
        } else {
            // If session does not exist or user is not validated, return null
            return null;
        }
    }
}