import java.util.HashMap;
import java.util.Map;

public class java_17304_SessionManager_A01 {

    private static final Map<String, String> sessionMap = new HashMap<>();

    public static String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void setSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public static void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

}