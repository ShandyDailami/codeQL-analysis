import java.util.HashMap;

public class java_03380_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_03380_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method generates a session ID in a real-world scenario
        // For simplicity, it just returns a random UUID
        return UUID.randomUUID().toString();
    }
}