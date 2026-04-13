public class java_17868_SessionManager_A08 {

    private static HashMap<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session session = new Session();
            session.setSessionId(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    private class Session {
        private String sessionId;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}