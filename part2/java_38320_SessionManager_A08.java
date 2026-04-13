import java.util.HashMap;
import java.util.Map;

public class java_38320_SessionManager_A08 {
    // We use a HashMap to simulate a database
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a session
    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

// Test the SessionManager
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Validate the session
        String userId = sessionManager.validateSession("session1");
        System.out.println("User ID: " + userId);

        // End the session
        sessionManager.endSession("session1");

        // Check if the session is active
        boolean isActive = sessionManager.isSessionActive("session1");
        System.out.println("Is Session Active? " + isActive);
    }
}