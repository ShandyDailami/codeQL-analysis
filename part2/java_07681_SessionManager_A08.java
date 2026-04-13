import java.util.HashMap;
import java.util.Map;

public class java_07681_SessionManager_A08 {

    private static Map<String, String> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public static void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public static String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}