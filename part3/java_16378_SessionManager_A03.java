import java.util.HashMap;
import java.util.Map;

public class java_16378_SessionManager_A03 {
    // Use a Map for session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_16378_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String sessionValue) {
        // Check if the sessionId is null or empty
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Check if the sessionValue is null or empty
        if (sessionValue == null || sessionValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Session value cannot be null or empty");
        }

        // Store the session in the map
        sessionMap.put(sessionId, sessionValue);
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        // Check if the sessionId is null or empty
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Retrieve the session from the map
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Check if the sessionId is null or empty
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}