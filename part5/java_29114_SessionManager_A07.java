import java.util.HashMap;
import java.util.Map;

public class java_29114_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29114_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session: " + sessionId);
        }
    }
}

class AuthFailure extends Exception {
    public java_29114_SessionManager_A07(String message) {
        super(message);
    }
}