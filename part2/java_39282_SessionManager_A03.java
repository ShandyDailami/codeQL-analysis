import java.util.HashMap;

public class java_39282_SessionManager_A03 {
    private static HashMap<String, String> sessionMap = new HashMap<>();
    private static ThreadLocal<String> sessionThreadLocal = new ThreadLocal<>();

    public static void startSession(String sessionId) {
        sessionThreadLocal.set(sessionId);
    }

    public static String getSessionId() {
        return sessionThreadLocal.get();
    }

    public static void endSession() {
        sessionMap.remove(sessionThreadLocal.get());
        sessionThreadLocal.set(null);
    }

    public static void put(String key, String value) {
        String sessionId = sessionThreadLocal.get();
        if (sessionId != null) {
            sessionMap.put(sessionId, value);
        }
    }

    public static String get(String key) {
        String sessionId = sessionThreadLocal.get();
        if (sessionId != null) {
            return sessionMap.get(sessionId);
        }
        return null;
    }
}