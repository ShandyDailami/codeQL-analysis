import java.util.HashMap;

public class java_20469_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_20469_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userId) {
        // TODO: Implement a secure way to generate session IDs. This is just a simple example.
        return userId;
    }
}