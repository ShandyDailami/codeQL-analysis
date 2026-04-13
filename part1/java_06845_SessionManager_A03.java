import java.util.HashMap;
import java.util.Map;

public class java_06845_SessionManager_A03 {
    // Create a map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_06845_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userID) {
        // Create a unique session ID and store it in the map
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID is valid
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session from the map
        sessionMap.remove(sessionID);
    }
}