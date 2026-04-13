import java.util.HashMap;

public class java_06586_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_06586_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    // Method to get the userID from a session
    public String getUserIDFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }
}