import java.util.HashMap;
import java.util.Map;

public class java_17643_SessionManager_A07 {
    // Create a map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_17643_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, username);
        return sessionID;
    }

    // Method to get the username from a session
    public String getUsername(String sessionID) {
        // Get the username from the session map
        return sessionMap.get(sessionID);
    }

    // Method to check if a session exists
    public boolean isValidSession(String sessionID) {
        // Check if the session ID exists in the session map
        return sessionMap.containsKey(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session from the session map
        sessionMap.remove(sessionID);
    }
}