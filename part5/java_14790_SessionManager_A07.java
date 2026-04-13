import java.util.HashMap;
import java.util.Map;

public class java_14790_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14790_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) throws AuthenticationException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthenticationException("Invalid session Id");
        }
        return sessionMap.get(sessionId);
    }
}

class AuthenticationException extends Exception {
    public java_14790_SessionManager_A07(String message) {
        super(message);
    }
}