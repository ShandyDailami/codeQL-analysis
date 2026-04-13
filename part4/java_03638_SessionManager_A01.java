public class java_03638_SessionManager_A01 {
    private static HashMap<String, String> sessionMap;

    // Initialize sessionMap as a static field in a static context
    static {
        sessionMap = new HashMap<>();
    }

    // Private constructor to restrict instantiation of the class
    private java_03638_SessionManager_A01() {}

    public static String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public static void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public static void invalidateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public static void clearAllSessions() {
        sessionMap.clear();
    }
}