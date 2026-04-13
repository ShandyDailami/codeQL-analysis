import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_39183_SessionManager_A01 {
    // ConcurrentHashMap for thread safety
    private Map<String, String> sessionMap;

    public java_39183_SessionManager_A01() {
        sessionMap = new ConcurrentHashMap<>();
    }

    // Session creation
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Session retrieval
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session invalidation
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operations
    public String secureOperation(String sessionId) {
        String userId = sessionMap.get(sessionId);
        
        // BrokenAccessControl: Access denied for all users
        if (userId == null) {
            throw new RuntimeException("Access denied for all users");
        }

        // Continue with security-sensitive operations...
        return userId;
    }
}