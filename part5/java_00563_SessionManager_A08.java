public class java_00563_SessionManager_A08 {

    private HashMap<String, Session> sessions;

    public java_00563_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).setAccessed(true);
        } else {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).setAccessed(false);
        }
    }

    public void checkIntegrity() {
        for (Session session : sessions.values()) {
            if (!session.isAccessed()) {
                throw new SecurityFailureException("Session integrity failure: SessionId=" + session.getSessionId());
            }
        }
    }

    // Session class
    class Session {

        private String sessionId;
        private boolean isAccessed;

        public java_00563_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setAccessed(boolean accessed) {
            isAccessed = accessed;
        }

        public boolean isAccessed() {
            return isAccessed;
        }
    }
}