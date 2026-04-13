import java.util.HashMap;
import java.util.Map;

public class java_33940_SessionManager_A03 {
    // Create a new instance of HashMap to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map when an instance of the class is created
    public java_33940_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Add session to map
        sessionMap.put(sessionId, sessionId);

        // Return session id
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        // Return the session id from the map
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Remove session from map
        sessionMap.remove(sessionId);
    }
}