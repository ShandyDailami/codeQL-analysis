import java.util.HashMap;
import java.util.Map;

public class java_21859_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_21859_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Session creation
    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Session retrieval
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session deletion
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session validation
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Session ID generation (this could be a hashing function)
    private String generateSessionId() {
        // Implementation specific, this is just a placeholder
        return "SESSION_ID";
    }
}