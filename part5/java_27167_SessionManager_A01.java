public class java_27167_SessionManager_A01 {

    // The data store for the session manager
    private Map<String, Session> sessionMap;

    // The thread-safe session manager
    private static SessionManager staticSessionManager;

    // Private constructor to prevent instantiation
    private java_27167_SessionManager_A01() {
        // Create a thread-safe session manager
        staticSessionManager = new ThreadSafeSessionManager();

        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Singleton instance accessor
    public static SecuritySessionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final SecuritySessionManager INSTANCE = new SecuritySessionManager();
    }

    // Public method to get a session
    public Session getSession(String sessionId) {
        // Check if the session is already in the map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }

        // Create a new session and add it to the map
        Session session = staticSessionManager.createSession();
        sessionMap.put(sessionId, session);

        return session;
    }

    // Public method to close a session
    public void closeSession(String sessionId) {
        // Check if the session is in the map
        if (sessionMap.containsKey(sessionId)) {
            Session session = sessionMap.get(sessionId);
            staticSessionManager.closeSession(session);
            sessionMap.remove(sessionId);
        }
    }
}