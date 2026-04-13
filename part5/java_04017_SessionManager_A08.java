public class java_04017_SessionManager_A08 {
    private static HashMap<String, String> sessionMap;

    // Initialize the session map
    static {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public static void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Get the userId associated with a session
    public static String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session
    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}