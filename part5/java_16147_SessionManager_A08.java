import java.util.HashMap;
import java.util.Map;

public class java_16147_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16147_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class IntegrityFailure {
    private SessionManager sessionManager;

    public java_16147_SessionManager_A08() {
        sessionManager = new SessionManager();
    }

    public void createSession(String userId) {
        String sessionId = generateSessionId();
        sessionManager.addSession(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionManager.isValidSession(sessionId)) {
            throw new SecurityException("Invalid session");
        }
        return sessionManager.getUserId(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionManager.isValidSession(sessionId)) {
            throw new SecurityException("Invalid session");
        }
        sessionManager.removeSession(sessionId);
    }

    private String generateSessionId() {
        // Generate session ID here
        // This is a dummy function. In a real application, you would want
        // to use a more complex mechanism to generate session IDs.
        return "session123";
    }
}