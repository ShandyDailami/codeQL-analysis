public class java_27810_SessionManager_A01 {

    private HashMap<String, Session> sessions;

    public java_27810_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) throws Exception {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new Exception("No session found with id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_27810_SessionManager_A01() {
            this.sessionId = UUID.randomUUID().toString();
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}