import java.util.HashMap;
import java.util.Map;

public class java_38860_SessionManager_A07 {
    // Use a HashMap for session storage
    private Map<String, String> sessionMap;

    public java_38860_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = userID + "_" + System.currentTimeMillis();

        // Store sessionID in sessionMap
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if sessionID exists in sessionMap
        if (sessionMap.containsKey(sessionID)) {
            // Get userID from sessionMap
            String userID = sessionMap.get(sessionID);

            // Validate the session, here we are just returning the userID
            return userID;
        } else {
            // Session is invalid
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionID) {
        // Remove sessionID from sessionMap
        sessionMap.remove(sessionID);
    }
}