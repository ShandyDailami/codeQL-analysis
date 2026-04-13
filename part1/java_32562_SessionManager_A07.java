import java.util.HashMap;
import java.util.Map;

public class java_32562_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32562_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple random session ID generator.
        // You might want to use a more complex logic in a real application.
        return String.valueOf(System.currentTimeMillis() * (int)Math.random());
    }
}