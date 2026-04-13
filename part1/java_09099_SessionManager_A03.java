import java.util.HashMap;
import java.util.Map;

public class java_09099_SessionManager_A03 {
    // A simple in-memory store for session data
    private Map<String, Object> sessionData;

    public java_09099_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, Object sessionObject) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Error: Invalid session ID.";
        }
        sessionData.put(sessionId, sessionObject);
        return "Successfully created session with ID: " + sessionId;
    }

    // Method to get data from a session
    public Object getSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Error: Invalid session ID.";
        }
        return sessionData.get(sessionId);
    }

    // Method to update data in a session
    public String updateSession(String sessionId, Object sessionObject) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Error: Invalid session ID.";
        }
        sessionData.put(sessionId, sessionObject);
        return "Successfully updated session with ID: " + sessionId;
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Error: Invalid session ID.";
        }
        sessionData.remove(sessionId);
        return "Successfully deleted session with ID: " + sessionId;
    }
}