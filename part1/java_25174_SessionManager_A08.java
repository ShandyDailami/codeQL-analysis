import java.util.HashMap;
import java.util.Map;

public class java_25174_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25174_SessionManager_A08() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Private method to generate a unique session id
    private String generateSessionId() {
        // This is a dummy implementation and should be replaced with a secure session id generation method
        return "sessionId" + System.currentTimeMillis();
    }

    // Sample operation to ensure integrity of session
    public void ensureSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
    }
}