import java.util.HashMap;
import java.util.Map;

public class java_11226_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11226_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a more complex session id generation
        // In a real-world scenario, you would use a UUID or similar to ensure uniqueness
        return "sessionId";
    }
}