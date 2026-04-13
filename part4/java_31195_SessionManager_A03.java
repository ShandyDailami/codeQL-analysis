import java.util.HashMap;
import java.util.Map;

public class java_31195_SessionManager_A03 {
    private static Map<String, String> sessionMap = new HashMap<>();

    public static void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public static String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Example of a security-sensitive operation related to A03_Injection
    public static void storePassword(String username, String password) {
        // This is a very simple example of password storage. It should not be used in a real-world application.
        sessionMap.put(username, password);
    }
}