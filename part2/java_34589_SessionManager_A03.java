import java.util.HashMap;
import java.util.Map;

public class java_34589_SessionManager_A03 {
    private static Map<String, String> sessionMap;

    // Initialize the session map
    static {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public static String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public static String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public static void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}