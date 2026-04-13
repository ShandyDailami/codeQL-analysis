import java.util.HashMap;
import java.util.Map;

public class java_22432_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22432_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) throws AuthenticationFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthenticationFailure("Invalid session ID");
        }
    }
}