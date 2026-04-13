import java.util.HashMap;

public class java_26683_SessionManager_A01 {
    // Use ThreadLocal to manage the sessions
    private static final ThreadLocal<String> sessionIdThreadLocal = new ThreadLocal<String>();

    // Use a map to store all sessions
    private static final HashMap<String, String> sessionMap = new HashMap<String, String>();

    // Create a new session
    public static String createSession(String userId) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionIdThreadLocal.set(sessionId);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get the userId of the current session
    public static String getUserId() {
        return sessionMap.get(sessionIdThreadLocal.get());
    }

    // Destroy the current session
    public static void destroySession() {
        sessionIdThreadLocal.set(null);
        sessionMap.remove(sessionIdThreadLocal.get());
    }
}