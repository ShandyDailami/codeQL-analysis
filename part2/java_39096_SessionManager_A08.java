import java.util.HashMap;
import java.util.Map;

public class java_39096_SessionManager_A08 {

    // Create a private static map of sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_39096_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if session id is already in use
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID already in use!");
            return null;
        }

        // If not in use, add session id to map and return it
        sessionMap.put(sessionId, "Session is active");
        return sessionId;
    }

    // Method to get session
    public String getSession(String sessionId) {
        // Check if session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist!");
            return null;
        }

        // If the session id exists in the map, return the session status
        return sessionMap.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        // Check if session id exists in the map
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist!");
            return;
        }

        // If session id exists in the map, remove it from the map
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " closed");
    }
}