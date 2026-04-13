import java.util.HashMap;
import java.util.Map;

public class java_11473_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11473_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Generate a session ID using a secure algorithm
        String sessionId = generateSecureSessionId(username);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a placeholder for a secure session ID generation method
    private String generateSecureSessionId(String username) {
        // Implement your own secure session ID generation algorithm here
        return "secure_" + username;
    }
}