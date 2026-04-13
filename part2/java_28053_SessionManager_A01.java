import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_28053_SessionManager_A01 {
    private Map<String, String> sessionMap; // Session ID and User ID

    public java_28053_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        // Generate a random session ID
        String sessionID = UUID.randomUUID().toString();

        // Store the session ID and user ID in the map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    public String getUserID(String sessionID) {
        // Return the user ID associated with the session ID
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        // Remove the session ID and user ID from the map
        sessionMap.remove(sessionID);
    }
}