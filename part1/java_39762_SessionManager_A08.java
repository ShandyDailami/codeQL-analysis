import java.util.HashMap;

public class java_39762_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_39762_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // You can use the following methods for generating sessionId.
    private String generateSessionId() {
        // You can add your own implementation of session id generation.
        // For example, you can use a unique timestamp or random string.
        return String.valueOf(System.nanoTime());
    }
}