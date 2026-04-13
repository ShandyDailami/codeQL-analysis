public class java_12553_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_12553_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessions.remove(sessionId);
        }
    }

    public class Session {
        private String id;
        private boolean isValid;

        public java_12553_SessionManager_A01(String id) {
            this.id = id;
            isValid = true;
        }

        public void invalidate() {
            isValid = false;
        }

        public boolean isValid() {
            return isValid;
        }
    }
}