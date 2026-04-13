import java.util.HashMap;
import java.util.Map;

public class java_19376_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19376_SessionManager_A03() {
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

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a session ID using a random generator or hashing method
    private String generateSessionId() {
        // Implementation here
    }
}