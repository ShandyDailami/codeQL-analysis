import java.util.HashMap;
import java.util.Map;

public class java_38590_SessionManager_A08 {
    private static Map<String, String> sessionMap = new HashMap<>();

    public static void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public static String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public static void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}