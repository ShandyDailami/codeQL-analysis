import java.util.HashMap;
import java.util.Map;

public class java_15102_SessionManager_A07 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    public java_15102_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Function to create a session
    public String createSession(String userId) {
        // Generate a random session id
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Function to validate a session
    public boolean validateSession(String sessionId) {
        // Implement a security-sensitive operation, like A07_AuthFailure
        // Here we'll simulate it by checking if the session id is in our session map
        return sessionMap.containsKey(sessionId);
    }

    // Function to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}