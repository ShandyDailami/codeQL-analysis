import java.util.HashMap;
import java.util.Map;

public class java_12032_SessionManager_A08 {
    // Private Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_12032_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to get the userID from a session
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}