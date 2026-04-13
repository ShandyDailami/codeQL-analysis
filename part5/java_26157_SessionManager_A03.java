import java.util.HashMap;
import java.util.Map;

public class java_26157_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26157_SessionManager_A03() {
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

    // This is a placeholder method. In a real-world scenario, you would use
    // a secure method to generate a session ID.
    private String generateSessionId() {
        // Placeholder for generating a session ID
        return "12345";
    }
}