public class java_19153_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_19153_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
            session.close();
        }
    }
}