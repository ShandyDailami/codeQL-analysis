public class java_35556_SessionManager_A07 {

    private int sessionIdCounter = 0;
    private Map<Integer, Session> sessions = new HashMap<>();

    public Session openSession() {
        Session session = new SessionImpl();
        session.setSessionId(++sessionIdCounter);
        sessions.put(session.getSessionId(), session);
        return session;
    }

    public Session getSession(int sessionId) throws SessionNotFoundException {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found: " + sessionId);
        }
        return session;
    }

    public void closeSession(int sessionId) throws SessionNotFoundException {
        Session session = getSession(sessionId);
        sessions.remove(sessionId);
    }

    // Inner classes

    private class SessionImpl implements Session {

        private int sessionId;

        @Override
        public int getSessionId() {
            return sessionId;
        }

        @Override
        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public void closeSession() {
            // security sensitive operation, remove session from sessions map
        }

    }
}