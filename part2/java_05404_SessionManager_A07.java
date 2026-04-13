import java.util.HashMap;

public class java_05404_SessionManager_A07 {
    // A HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_05404_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    // Method to get the userID from a session
    public String getUserIDFromSession(String sessionID) {
        if (validateSession(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            throw new RuntimeException("Invalid Session ID");
        }
    }

    // Method to remove a session
    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}