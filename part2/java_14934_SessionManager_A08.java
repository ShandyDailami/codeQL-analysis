import java.util.HashMap;
import java.util.Map;

public class java_14934_SessionManager_A08 {

    // A simple map to store sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_14934_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String sessionId) {
        // Validate sessionId
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }

        // Store sessionId and value in map
        sessionMap.put(sessionId, "SessionActive");
    }

    // Method to stop a session
    public void stopSession(String sessionId) {
        // Validate sessionId
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }

        // Remove sessionId from map
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is active
    public String isSessionActive(String sessionId) {
        // Validate sessionId
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }

        // Return the status of the session
        return sessionMap.get(sessionId);
    }
}