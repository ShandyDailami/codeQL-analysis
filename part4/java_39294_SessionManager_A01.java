import java.util.HashMap;
import java.util.Map;

public class java_39294_SessionManager_A01 {
    // Map to store session IDs and their validity.
    private Map<String, Boolean> sessionMap;

    public java_39294_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session for a given user.
    public String startSession(String user) {
        String sessionID = user + "_" + System.currentTimeMillis();
        sessionMap.put(sessionID, true);
        return sessionID;
    }

    // Method to check if a session is still valid.
    public boolean isValidSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            return false;
        }
    }

    // Method to end a session.
    public void endSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, false);
        }
    }
}