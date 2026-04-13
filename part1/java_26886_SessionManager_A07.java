import java.util.HashMap;
import java.util.Map;

public class java_26886_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26886_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid session id!");
        }
    }
}

public class AuthFailureException extends RuntimeException {
    public java_26886_SessionManager_A07(String message) {
        super(message);
    }
}