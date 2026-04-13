import java.util.HashMap;
import java.util.Map;

public class java_02085_SessionManager_A07 {
    // Map to store session data
    private Map<String, Object> sessionData;

    // Constructor
    public java_02085_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // If sessionId already exists, return an error message
        if (this.sessionData.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " already exists";
        }

        // Otherwise, add the sessionId to the map
        this.sessionData.put(sessionId, null);
        return "Successfully created session with id " + sessionId;
    }

    // Method to retrieve session data
    public Object getSessionData(String sessionId) {
        // If sessionId does not exist, return an error message
        if (!this.sessionData.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists";
        }

        // Otherwise, return the session data
        return this.sessionData.get(sessionId);
    }

    // Method to update session data
    public void updateSessionData(String sessionId, Object sessionData) {
        // If sessionId does not exist, return an error message
        if (!this.sessionData.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists";
        }

        // Otherwise, update the session data
        this.sessionData.put(sessionId, sessionData);
    }

    // Method to delete session
    public String deleteSession(String sessionId) {
        // If sessionId does not exist, return an error message
        if (!this.sessionData.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists";
        }

        // Otherwise, delete the session
        this.sessionData.remove(sessionId);
        return "Successfully deleted session with id " + sessionId;
    }
}