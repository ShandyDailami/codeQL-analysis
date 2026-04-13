import java.util.HashMap;
import java.util.Map;

public class java_13974_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13974_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
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

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityFailureException("Invalid session: " + sessionId);
        }
    }
}