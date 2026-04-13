import java.util.HashMap;
import java.util.Map;

public class java_11669_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11669_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }
    }

    // This is a placeholder. You should replace this with your actual session ID generation logic.
    private String generateSessionId() {
        return "A07_AuthFailure";
    }
}