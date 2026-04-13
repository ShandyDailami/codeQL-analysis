import java.util.HashMap;
import java.util.Map;

public class java_16140_SessionManager_A08 {
    // Create a new instance of HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_16140_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return "Error: Session already exists with id: " + sessionID;
        } else {
            sessionMap.put(sessionID, sessionID);
            return "Session created successfully with id: " + sessionID;
        }
    }

    // Method to retrieve a session
    public String getSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return "Session with id: " + sessionID + " found";
        } else {
            return "Error: Session with id: " + sessionID + " does not exist";
        }
    }

    // Method to update a session
    public String updateSession(String sessionID, String newSessionID) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, newSessionID);
            return "Session with id: " + sessionID + " updated to " + newSessionID;
        } else {
            return "Error: Session with id: " + sessionID + " does not exist";
        }
    }

    // Method to delete a session
    public String deleteSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.remove(sessionID);
            return "Session with id: " + sessionID + " deleted";
        } else {
            return "Error: Session with id: " + sessionID + " does not exist";
        }
    }
}