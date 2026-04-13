import java.util.HashMap;

public class java_09386_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_09386_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        String sessionID = userID + "_" + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to get the userID from a session
    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to remove a session
    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}