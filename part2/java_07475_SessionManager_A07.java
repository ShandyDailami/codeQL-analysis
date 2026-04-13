import java.util.HashMap;
import java.util.Map;

public class java_07475_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_07475_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        // Sensitive operation: Check if sessionId is valid and the session is active
        if (sessionMap.containsKey(sessionId) && isSessionActive(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session: " + sessionId);
        }
    }

    private boolean isSessionActive(String sessionId) {
        // Implementation of a method to check if session is active
        // This is a placeholder and won't work in a real-world scenario
        return true;
    }
}