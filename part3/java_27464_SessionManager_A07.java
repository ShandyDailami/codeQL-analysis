import java.util.HashMap;
import java.util.Map;

public class java_27464_SessionManager_A07 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_27464_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Start a new session
    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    // Stop an existing session
    public void stopSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Implement a security-sensitive operation
    public void authFailure(String sessionId) {
        if (!isValidSession(sessionId)) {
            System.out.println("Invalid session: " + sessionId);
            // Here, we are simulating a security breach by stopping the session.
            stopSession(sessionId);
        }
    }
}