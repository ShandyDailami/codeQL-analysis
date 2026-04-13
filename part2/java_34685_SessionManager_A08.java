import java.util.HashMap;
import java.util.Map;

public class java_34685_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34685_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operation: A08_IntegrityFailure
    public void integrityFailure(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserId);
        } else {
            createSession(sessionId, newUserId);
        }
    }
}