import java.util.HashMap;
import java.util.Map;

public class java_29585_SessionManager_A01 {

    // Create a new HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_29585_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if the session ID is already in use
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID already in use");
        }
        // Add the session to the map
        sessionMap.put(sessionId, "Session Data");
        return sessionId;
    }

    // Method to get the session data
    public String getSessionData(String sessionId) {
        // Check if the session ID exists
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID does not exist");
        }
        // Get the session data
        return sessionMap.get(sessionId);
    }

    // Method to delete the session
    public void deleteSession(String sessionId) {
        // Check if the session ID exists
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID does not exist");
        }
        // Delete the session from the map
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionId = manager.createSession("1234");
        System.out.println("Session ID: " + sessionId);

        // Get the session data
        System.out.println("Session Data: " + manager.getSessionData(sessionId));

        // Delete the session
        manager.deleteSession(sessionId);
    }
}