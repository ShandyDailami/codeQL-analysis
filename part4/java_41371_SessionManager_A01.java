import java.util.HashMap;

public class java_41371_SessionManager_A01 {
    private static HashMap<String, String> sessionStore = new HashMap<>();
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void startSession(String userId) {
        threadLocal.set(userId);
    }

    public static String getSessionId() {
        return threadLocal.get();
    }

    public static void endSession() {
        threadLocal.set(null);
    }

    public static void setAttribute(String attributeName, String attributeValue) {
        sessionStore.put(attributeName, attributeValue);
    }

    public static String getAttribute(String attributeName) {
        return sessionStore.get(attributeName);
    }
}