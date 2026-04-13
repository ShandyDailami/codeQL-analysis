public class java_18962_SessionManager_A07 {
    private static Map<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    // Using static SessionManager instance for thread-safe operations
    public static SessionManager getInstance() {
        return Holder.INSTANCE;
    }

    private java_18962_SessionManager_A07() {}

    private static class Holder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public Session getSession(String userId) {
        Session session = sessionMap.get(userId);
        if (session == null) {
            session = createSession(userId);
            sessionMap.put(userId, session);
        }
        return session;
    }

    private Session createSession(String userId) {
        // Implementation to create a new Session
        return new Session(userId);
    }

    public void closeSession(Session session) {
        sessionMap.remove(session.getUserId());
        // Implementation to close the Session
        session.close();
    }
}