import java.util.HashMap;
import java.util.Map;

public class java_27981_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_27981_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // Injecting userId to protect against SQL Injection
        // This is a very basic example and does not protect against all possible attacks
        String sanitizedUserId = sanitizeInput(userId);
        String sessionId = String.valueOf(sanitizedUserId.hashCode());
        sessionMap.put(sessionId, sanitizedUserId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Injecting sessionId to protect against Session ID theft
        String sanitizedSessionId = sanitizeInput(sessionId);
        return sessionMap.get(sanitizedSessionId);
    }

    private String sanitizeInput(String input) {
        // This is a very basic example of input sanitization and should not be used in a real-world application
        // It only removes non-alphanumeric characters and returns the sanitized input
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }
}