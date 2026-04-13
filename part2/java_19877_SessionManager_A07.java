import java.util.HashMap;
import java.util.Map;

public class java_19877_SessionManager_A07 {
    // In-memory storage for sessions
    private Map<String, String> sessionMap;

    // SessionManager constructor
    public java_19877_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Check if session ID is already in use
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session ID is already in use");
        }

        // Otherwise, store the session ID
        sessionMap.put(sessionId, sessionId);

        // Return the session ID
        return sessionId;
    }

    // Method to get a session by its ID
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session by its ID
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}