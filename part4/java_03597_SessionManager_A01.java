import java.util.HashMap;
import java.util.Map;

public class java_03597_SessionManager_A01 {

    // Map to hold sessions.
    private Map<String, String> sessionMap;

    public java_03597_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session.
    public void startSession(String userID, String sessionID) {
        sessionMap.put(sessionID, userID);
        System.out.println("Session started for user: " + userID + " with sessionID: " + sessionID);
    }

    // Method to end a session.
    public void endSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            String userID = sessionMap.get(sessionID);
            sessionMap.remove(sessionID);
            System.out.println("Session ended for user: " + userID + " with sessionID: " + sessionID);
       
        } else {
            System.out.println("No active session found with sessionID: " + sessionID);
        }
    }

    // Method to get the userID of the user who has the session.
    public String getUserID(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            System.out.println("No active session found with sessionID: " + sessionID);
            return null;
        }
    }
}