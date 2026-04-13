public class java_22183_SessionManager_A08 {
    private static int currentSessionId = 0;
    private static SessionManager instance;
    private Map<Integer, Session> sessions;

    private java_22183_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        int sessionId = currentSessionId++;
        Session session = new SessionImpl(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(int sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(int sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }
}