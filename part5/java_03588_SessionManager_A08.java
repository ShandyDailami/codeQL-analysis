import java.util.HashMap;

public class java_03588_SessionManager_A08 {
    // Private field for storing sessions
    private HashMap<String, String> sessionMap;

    // Default constructor
    public java_03588_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String sessionID) {
        // Add session to session map
        sessionMap.put(sessionID, sessionID);

        // Return success message
        return "Session created successfully";
    }

    // Method for validating a session
    public String validateSession(String sessionID) {
        // Check if session exists in session map
        if (sessionMap.containsKey(sessionID)) {
            // Return success message
            return "Session validated successfully";
        } else {
            // Return failure message
            return "Invalid session";
        }
    }

    // Method for destroying a session
    public String destroySession(String sessionID) {
        // Remove session from session map
        sessionMap.remove(sessionID);

        // Return success message
        return "Session destroyed successfully";
    }
}