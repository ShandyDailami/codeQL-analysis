import java.util.HashMap;
import java.util.Map;

public class java_01094_SessionManager_A03 {

    private static Map<String, String> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    // Constructor, getter, and setter
    public java_01094_SessionManager_A03() {
    }

    public static Map<String, String> getSessionMap() {
        return sessionMap;
    }

    // Session creation
    public String createSession(String sessionId, String userId) {
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