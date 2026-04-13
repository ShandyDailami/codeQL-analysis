import java.util.HashMap;
import java.util.Map;

public class java_05367_SessionManager_A07 {
    // Create a map for storing sessions
    private Map<String, String> sessionMap;

    public java_05367_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
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