public class java_14202_SessionManager_A03 {
    private static HashMap<String, Session> activeSessions = new HashMap<>();

    public static Session getSession(String sessionId) {
        if (activeSessions.containsKey(sessionId)) {
            return activeSessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            activeSessions.put(sessionId, session);
            return session;
        }
    }

    public static void invalidateSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    private static class Session {
        private String sessionId;

        public java_14202_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}