import java.util.HashMap;
import java.util.Map;

public class java_08025_SessionManager_A01 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_08025_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a session
    public void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // If the session is not validated yet
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Invalid session");
            return null;
        }

        // If the session is validated, return the user associated with the session
        return sessionMap.get(sessionId);
    }

    // Method to terminate a session
    public void terminateSession(String sessionId) {
        // If the session is not validated yet
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Invalid session to be terminated");
            return;
        }

        // If the session is validated, remove it from the map
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " has been terminated");
    }
}