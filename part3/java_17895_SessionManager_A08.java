import java.util.*;

public class java_17895_SessionManager_A08 {

    private static Map<String, String> sessionMap = new HashMap<>();

    public static String createSession(String userId) {
        // Generate a unique session id
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public static String getUserId(String sessionId) {
        // If session is invalid or expired, return null
        if (!sessionMap.containsKey(sessionId)) {
            return null;
        }
        // If session is valid, return the user id
        return sessionMap.get(sessionId);
    }

    public static void deleteSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}