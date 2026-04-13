import java.util.HashMap;
import java.util.Map;

public class java_12880_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_12880_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        // Add the sessionId and session details to the sessionMap
        sessionMap.put(sessionId, sessionId);
        return "Session created with ID: " + sessionId;
    }

    public String getSessionDetails(String sessionId) {
        // Retrieve the session details from the sessionMap
        return "Session Details for ID: " + sessionId + ", Details: " + sessionMap.get(sessionId);
    }

    public String deleteSession(String sessionId) {
        // Remove the session from the sessionMap
        sessionMap.remove(sessionId);
        return "Session with ID " + sessionId + " deleted.";
    }

    public String checkSessionIntegrity(String sessionId) {
        // Check if the session exists in the sessionMap
        if (sessionMap.containsKey(sessionId)) {
            return "Session with ID " + sessionId + " is correct.";
        } else {
            return "Session with ID " + sessionId + " is incorrect.";
        }
    }
}