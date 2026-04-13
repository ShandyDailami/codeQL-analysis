import java.util.HashMap;
import java.util.Map;

public class java_13247_SessionManager_A03 {
    // Create a HashMap to simulate a database
    private Map<String, String> sessionMap = new HashMap<>();

    // Session creation
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Session retrieval
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session invalidation
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}