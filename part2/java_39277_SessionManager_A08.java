import java.util.HashMap;
import java.util.Map;

public class java_39277_SessionManager_A08 {

    private static Map<String, String> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public static void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public static void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}