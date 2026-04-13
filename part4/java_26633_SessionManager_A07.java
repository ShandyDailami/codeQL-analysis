import java.util.HashMap;
import java.util.Map;

public class java_26633_SessionManager_A07 {

    private static final Map<String, String> sessionMap = new HashMap<>();

    public static String getSessionId(String userId) {
        // Add session logic
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public static String getUserId(String sessionId) {
        // Retrieve user logic
        return sessionMap.get(sessionId);
    }

    public static void invalidateSession(String sessionId) {
        // Invalidate session logic
        sessionMap.remove(sessionId);
    }
}