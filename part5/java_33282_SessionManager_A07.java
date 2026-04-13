import java.util.HashMap;
import java.util.Map;

public class java_33282_SessionManager_A07 {

    // In-memory data structure for storing session information
    private Map<String, String> sessionData;

    public java_33282_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method for creating a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionData.put(sessionId, userId);
        return sessionId;
    }

    // Method for validating a session
    public String validateSession(String sessionId) {
        if (!sessionData.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }
        return sessionData.get(sessionId);
    }

    // Method for destroying a session
    public void destroySession(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.remove(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }
}