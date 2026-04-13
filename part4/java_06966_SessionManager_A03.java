import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_06966_SessionManager_A03 {
    // A Map to store session data
    private Map<String, String> sessionMap;

    // A simple constructor
    public java_06966_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession() {
        // Generate a unique session ID
        String sessionId = UUID.randomUUID().toString();
        // Store the session ID and session data in the session map
        sessionMap.put(sessionId, "Session Data");
        // Return the session ID
        return sessionId;
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        // Return the session data
        return sessionMap.get(sessionId);
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String sessionId = manager.createSession();
        System.out.println("Session ID: " + sessionId);
        System.out.println("Session Data: " + manager.getSessionData(sessionId));
    }
}