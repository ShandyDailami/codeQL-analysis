import java.util.HashMap;
import java.util.Map;

public class java_19643_SessionManager_A03 {
    // Map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_19643_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        // Generate a session ID using username
        String sessionID = username + System.currentTimeMillis();
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    // Method to end a session
    public String endSession(String sessionID) {
        // Remove the session from the map
        sessionMap.remove(sessionID);

        return sessionID;
    }

    // Method to get the username of a session
    public String getUsername(String sessionID) {
        // Return the username of the session
        return sessionMap.get(sessionID);
    }
}