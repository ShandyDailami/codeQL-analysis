import java.util.HashMap;
import java.util.Map;

public class java_13255_SessionManager_A07 {

    private static Map<String, String> sessionMap = new HashMap<>();

    public static String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public static String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void checkAuthFailure(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            throw new AuthFailureException("Auth failure: Invalid session");
        }
        // continue with other operations
    }
}