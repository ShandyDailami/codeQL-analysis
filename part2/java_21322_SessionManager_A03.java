import java.util.HashMap;
import java.util.Map;

public class java_21322_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_21322_SessionManager_A03() {
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

    public void validateSession(String sessionId) throws SessionExpiredException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionExpiredException("Session has expired or it does not exist.");
        }
    }
}