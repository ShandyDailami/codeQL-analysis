import java.util.HashMap;
import java.util.Map;

public class java_28074_SessionManager_A03 {
    // A map to hold user sessions.
    private Map<String, String> sessionMap;

    public java_28074_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionID, userID); // Store the session ID and user ID in the map
        return sessionID;
    }

    // Method to validate a session
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}