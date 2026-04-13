import java.util.HashMap;
import java.util.Map;

public class java_37902_SessionManager_A08 {
    // Session data
    private Map<String, String> sessionMap;

    // Session Manager constructor
    public java_37902_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("New session started with ID: " + sessionId);
        }
    }

    // Method to check the integrity of a session
    public void checkSessionIntegrity(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session " + sessionId + " belongs to user " + userId + ".");
        } else {
            System.out.println("Session " + sessionId + " does not exist.");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended by user " + userId + ".");
        } else {
            System.out.println("Session " + sessionId + " does not exist.");
        }
    }
}