import java.util.HashMap;
import java.util.Map;

public class java_07888_SessionManager_A01 {
    // A Map to store user sessions.
    // Key: User ID, Value: Session ID
    private Map<String, String> sessionMap;

    public java_07888_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    // If the user ID already exists, return an error message.
    // Otherwise, create a new session and return the session ID.
    public String createSession(String userID) {
        if (sessionMap.containsKey(userID)) {
            return "Error: User ID already exists.";
        } else {
            String sessionID = userID + System.currentTimeMillis();
            sessionMap.put(userID, sessionID);
            return sessionID;
        }
    }

    // Method to get the session information.
    // If the session ID does not exist, return an error message.
    // Otherwise, return the session information.
    public String getSessionInfo(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            return "Error: Invalid session ID.";
        } else {
            String userID = sessionMap.get(sessionID);
            return "User ID: " + userID;
        }
    }

    // Method to remove the session.
    // If the session ID does not exist, return an error message.
    // Otherwise, remove the session and return a success message.
    public String removeSession(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            return "Error: Invalid session ID.";
        } else {
            sessionMap.remove(sessionID);
            return "Successfully removed session.";
        }
    }
}