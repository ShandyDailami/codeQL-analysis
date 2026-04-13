import java.util.HashMap;
import java.util.Map;

public class java_29784_SessionManager_A03 {
    // A HashMap to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_29784_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Security sensitive operation: Check if sessionId is valid
        // This operation is intentionally left vague for the purpose of this example
        // In a real application, a secure way of validating sessionId would be implemented
        // e.g., sessionMap.get(sessionId) != null

        // Assuming sessionId is valid
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Security sensitive operation: Remove session data
        // This operation is intentionally left vague for the purpose of this example
        // In a real application, a secure way of ending a session would be implemented
        // e.g., sessionMap.remove(sessionId)

        sessionMap.remove(sessionId);
    }
}