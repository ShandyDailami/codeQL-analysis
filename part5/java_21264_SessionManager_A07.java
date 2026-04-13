import java.util.HashMap;
import java.util.Map;

public class java_21264_SessionManager_A07 {

    private static Map<String, String> sessionMap;

    public static void startSession(String sessionId, String userId) {
        sessionMap = new HashMap<>();
        sessionMap.put("sessionId", sessionId);
        sessionMap.put("userId", userId);
    }

    public static String getUserId(String sessionId) {
        if (sessionMap.containsKey("sessionId") && sessionMap.get("sessionId").equals(sessionId)) {
            return sessionMap.get("userId");
        } else {
            return null;
        }
    }

    public static void endSession(String sessionId) {
        sessionMap.remove("sessionId");
        sessionMap.remove("userId");
    }
}