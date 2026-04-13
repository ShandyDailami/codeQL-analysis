import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_09330_SessionManager_A01 {
    private static Map<String, String> sessionMap = new HashMap<>();

    public static String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public static String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}