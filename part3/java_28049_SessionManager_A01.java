import java.util.HashMap;
import java.util.Map;

public class java_28049_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_28049_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Start Session
    public String startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // End Session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Get UserId from Session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Generate Session ID
    private String generateSessionId() {
        // Generating a random session id for the purpose of simplicity
        // In a real application, you should replace this with a more secure mechanism
        return String.valueOf(System.currentTimeMillis());
    }
}