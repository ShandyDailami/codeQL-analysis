import java.util.HashMap;
import java.util.Map;

public class java_01899_SessionManager_A01 {

    // HashMap to store session data
    private Map<String, String> sessionData;

    public java_01899_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a random session ID
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionData.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID is valid
        if (sessionData.containsKey(sessionID)) {
            // Return the user ID associated with the session
            return sessionData.get(sessionID);
        } else {
            // Return null if the session ID is invalid
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session from the map
        sessionData.remove(sessionID);
    }
}