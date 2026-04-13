public class java_17277_SessionManager_A08 {

    private static HashMap<String, String> sessionMap;

    // Initialize the session map
    static {
        sessionMap = new HashMap<>();
    }

    // Check if a user is authenticated and authorized for a session
    public static boolean checkSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Create a new session for a user
    public static void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    // End a session for a user
    public static void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Get the username for a session
    public static String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }
}