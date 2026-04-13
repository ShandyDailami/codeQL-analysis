import java.util.HashMap;
import java.util.Map;

public class java_09563_SessionManager_A01 {
    // Define a map to hold session data
    private Map<String, String> sessionData;

    public java_09563_SessionManager_A01() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionID) {
        if (sessionData.containsKey(sessionID)) {
            return "Error: Session ID already exists";
        }
        sessionData.put(sessionID, "Session data for " + sessionID);
        return "Successfully created session with ID: " + sessionID;
    }

    // Method to retrieve session data
    public String getSessionData(String sessionID) {
        if (!sessionData.containsKey(sessionID)) {
            return "Error: Session ID does not exist";
        }
        return sessionData.get(sessionID);
    }

    // Method to update session data
    public String updateSessionData(String sessionID, String newData) {
        if (!sessionData.containsKey(sessionID)) {
            return "Error: Session ID does not exist";
        }
        sessionData.put(sessionID, newData);
        return "Successfully updated session data for " + sessionID;
    }

    // Method to delete session
    public String deleteSession(String sessionID) {
        if (!sessionData.containsKey(sessionID)) {
            return "Error: Session ID does not exist";
        }
        sessionData.remove(sessionID);
        return "Successfully deleted session " + sessionID;
    }
}