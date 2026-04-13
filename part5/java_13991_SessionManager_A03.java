import java.util.HashMap;
import java.util.Map;

public class java_13991_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_13991_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to generate session id for session management.
    private String generateSessionId() {
        // Simulate session id generation
        return "sessionId";
    }
}