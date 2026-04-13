import java.util.HashMap;
import java.util.Map;

public class java_32592_SessionManager_A08 {
    private static Map<String, String> sessionMap = new HashMap<>();

    public static String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void setSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public static void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        // Testing
        SessionManager.setSession("session1", "value1");
        SessionManager.setSession("session2", "value2");
        System.out.println(SessionManager.getSession("session1")); // Should print value1
        System.out.println(SessionManager.getSession("session2")); // Should print value2
        SessionManager.invalidateSession("session1");
        System.out.println(SessionManager.getSession("session1")); // Should print null (session is invalidated)
    }
}