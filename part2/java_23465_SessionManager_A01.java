public class java_23465_SessionManager_A01 {
    private static int currentSessionId = 0;
    private static List<Session> sessions = new ArrayList<>();

    public Session createSession() {
        Session session = new SessionImpl();
        session.setSessionId(++currentSessionId);
        sessions.add(session);
        return session;
    }

    public Session getSession(int sessionId) {
        for (Session session : sessions) {
            if (session.getSessionId() == sessionId) {
                return session;
            }
        }
        return null;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }
}

interface Session {
    int getSessionId();
    void setSessionId(int sessionId);
    // other session-related methods
}

class SessionImpl implements Session {
    private int sessionId;
    // implement the methods here
}