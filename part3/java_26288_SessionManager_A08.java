import java.util.HashMap;
import java.util.Map;

public class java_26288_SessionManager_A08 {

    // Using a Map to simulate a session
    private Map<String, String> sessionMap;

    public java_26288_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generating a unique session ID
        String sessionID = userID + System.currentTimeMillis();

        // Store the session ID and user ID in the map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}