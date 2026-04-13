import java.util.HashMap;
import java.util.Map;

public class java_42061_SessionManager_A01 {
    // Using a HashMap to store sessions
    private Map<String, String> sessionMap;

    // SessionManager constructor
    public java_42061_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public String addSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID already in use. Please use a new session ID.");
            return null;
        }

        // Check if sessionId is null
        if (sessionId == null) {
            System.out.println("Session ID cannot be null. Please use a new session ID.");
            return null;
        }

        // Add sessionId to sessionMap
        sessionMap.put(sessionId, "Active");
        return sessionId;
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        // Check if sessionId is not in use
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session with the provided session ID.");
            return null;
        }

        // Remove sessionId from sessionMap
        sessionMap.remove(sessionId);
        return sessionId;
    }

    // Method to check if a session is active
    public String checkSession(String sessionId) {
        // Check if sessionId is not in use
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session with the provided session ID.");
            return null;
        }

        // Return the sessionId status
        return sessionMap.get(sessionId);
    }
}