import java.util.HashMap;
import java.util.Map;

public class java_39597_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39597_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Session is valid, continue with authentication
        } else {
            // Session is invalid, fail the authentication
            throw new AuthFailureException();
        }
    }
}