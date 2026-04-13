import java.util.HashMap;
import java.util.Map;

public class java_08807_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08807_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Session creation
    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session id
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Session retrieval
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session invalidation
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}