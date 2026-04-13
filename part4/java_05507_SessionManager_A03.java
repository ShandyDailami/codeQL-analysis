import java.util.HashMap;
import java.util.Map;

public class java_05507_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05507_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Injects the username into the session map via a secure way
        String sanitizedUsername = sanitizeUsername(username);
        sessionMap.put("session_id", sanitizedUsername);
    }

    public String getSession(String sessionId) {
        // Retrieves the session from the session map via a secure way
        String sanitizedSessionId = sanitizeSessionId(sessionId);
        return sessionMap.getOrDefault(sanitizedSessionId, null);
    }

    private String sanitizeUsername(String username) {
        // Simple sanitization, remove all characters except alphanumeric and underscore
        return username.replaceAll("[^a-zA-Z0-9_]", "");
    }

    private String sanitizeSessionId(String sessionId) {
        // Simple sanitization, remove all characters except alphanumeric
        return sessionId.replaceAll("[^a-zA-Z0-9]", "");
    }
}