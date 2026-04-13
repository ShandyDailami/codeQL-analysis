import java.util.HashMap;
import java.util.Map;

public class java_42112_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_42112_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session id
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-related operations
    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session Id: " + sessionId);
        }
    }

    public void checkSessionExpiration(String sessionId) {
        String userId = sessionMap.get(sessionId);
        // Implementation to check session expiration here...
    }
}