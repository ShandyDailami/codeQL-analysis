public class java_13177_SessionManager_A07 {
    private static SessionManager instance;
    private java_13177_SessionManager_A07() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private HashMap<String, Session> sessions = new HashMap<>();

    public Session startSession(String userId) {
        Session session = new Session();
        session.userId = userId;
        sessions.put(userId, session);
        return session;
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }
}

public class Session {
    public String userId;
    // other session-related details here
}