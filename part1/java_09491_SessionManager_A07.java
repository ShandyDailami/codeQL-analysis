import java.util.HashMap;
import java.util.Map;

public class java_09491_SessionManager_A07 {
    // Define a Map to hold session information
    private Map<String, String> sessionMap;

    public java_09491_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userName) {
        // Generate a session ID and store it in the session map
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);

        // Return the session ID
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID is in the session map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user name for a session
    public String getUserName(String sessionId) {
        // Check if the session ID is in the session map
        if (validateSession(sessionId)) {
            // Return the user name
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session ID");
        }
    }
}