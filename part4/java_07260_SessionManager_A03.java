import java.util.HashMap;
import java.util.Map;

public class java_07260_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_07260_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get user id from session
    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Validate session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Generate session id
    private String generateSessionId() {
        // This is a very basic and not secure way of generating session id,
        // in a real-world application, you should use UUIDs or similar to avoid collisions
        return String.valueOf(System.currentTimeMillis());
    }
}