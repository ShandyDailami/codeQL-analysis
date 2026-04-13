import java.util.HashMap;
import java.util.Map;

public class java_30478_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30478_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Session " + sessionId + " started for user " + username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + username);
    }

    private String generateSessionId() {
        // This is a placeholder for a real session id generation.
        // In a real-world application, this would be done using UUID or similar.
        return "SessionId" + System.currentTimeMillis();
    }
}