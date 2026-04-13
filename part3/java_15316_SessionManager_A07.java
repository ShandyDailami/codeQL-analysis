import java.util.HashMap;
import java.util.Map;

public class java_15316_SessionManager_A07 {

    // Create a new instance of HashMap
    private Map<String, String> sessionMap;

    // Initialize the sessionMap
    public java_15316_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to add a session
    public String addSession(String sessionId) {
        // Add the sessionId to the sessionMap
        sessionMap.put(sessionId, sessionId);

        // Return the sessionId
        return sessionId;
    }

    // Method to remove a session
    public boolean removeSession(String sessionId) {
        // Remove the sessionId from the sessionMap
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return true;
        }

        // If the sessionId doesn't exist in the sessionMap, return false
        return false;
    }

    // Method to get the session
    public String getSession(String sessionId) {
        // Return the value corresponding to the sessionId
        return sessionMap.get(sessionId);
    }
}