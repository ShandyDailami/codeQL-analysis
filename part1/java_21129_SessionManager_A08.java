import java.util.HashMap;
import java.util.Map;

public class java_21129_SessionManager_A08 {
    // Declare a HashMap to store session IDs and user names
    private Map<String, String> sessionMap;

    // Default Constructor
    public java_21129_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userName) {
        // Generate a unique session ID
        String sessionId = System.currentTimeMillis() + "-" + userName;

        // Add the session ID and user name to the map
        sessionMap.put(sessionId, userName);

        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID is in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user name associated with a session
    public String getUserName(String sessionId) {
        // Check if the session ID is in the map
        if (validateSession(sessionId)) {
            // Return the user name associated with the session ID
            return sessionMap.get(sessionId);
        } else {
            // Return null if the session ID is not valid
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Check if the session ID is in the map
        if (validateSession(sessionId)) {
            // Remove the session ID and user name from the map
            sessionMap.remove(sessionId);
        }
    }
}