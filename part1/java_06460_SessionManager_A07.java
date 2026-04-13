import java.util.HashMap;
import java.util.Map;

public class java_06460_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06460_SessionManager_A07() {
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
        // This is a placeholder method, it should be replaced with a secure method
        // to generate a unique session id.
        return userId;
    }
}