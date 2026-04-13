import java.util.HashMap;
import java.util.Map;

public class java_05410_SessionManager_A07 {

    // Private field to store sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_05410_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        String sessionID = Integer.toString(sessionMap.size() + 1);
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

    // Method to delete a session
    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

}