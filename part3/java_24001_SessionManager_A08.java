import java.util.HashMap;
import java.util.Map;

public class java_24001_SessionManager_A08 {

    // Store the sessions in a HashMap
    private Map<String, String> sessionMap;

    // Constructor
    public java_24001_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session
    public String getSession(String sessionId) {
        // Check if the session exists
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to delete the session
    public void deleteSession(String sessionId) {
        // Check if the session exists
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    // Method to check if a session exists
    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to validate the session
    public boolean validateSession(String sessionId) {
        // Check if the session exists and is active
        if (sessionExists(sessionId) && sessionMap.get(sessionId) != null) {
            return true;
        }
        return false;
    }
}