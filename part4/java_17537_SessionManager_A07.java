import java.util.HashMap;

public class java_17537_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_17537_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + "_" + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // Security-sensitive operation: Check if a session is valid
    public boolean isValidSession(String sessionID) {
        // This is a simple check. In a real-world application, you'd likely have more complex logic.
        if (sessionMap.containsKey(sessionID)) {
            return true;
        }
        return false;
    }
}