import java.util.HashMap;
import java.util.Map;

public class java_05716_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05716_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Start a session
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        System.out.println("Started session for user: " + userId + " with session id: " + sessionId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // End a session
        String userId = sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + userId + " with session id: " + sessionId);
    }

    private String generateSessionId() {
        // Implementation for generating session id
        // This will be a dummy session id
        return "session123";
    }
}