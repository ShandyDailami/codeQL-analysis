import java.util.HashMap;
import java.util.Map;

public class java_08894_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08894_SessionManager_A08() {
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

    private String generateSessionId() {
        // This is a placeholder, you would typically generate a random UUID here.
        return "SESSION_" + System.nanoTime();
    }
}