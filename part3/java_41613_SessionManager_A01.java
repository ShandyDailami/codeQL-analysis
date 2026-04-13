public class java_41613_SessionManager_A01 {
    private static Map<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public static Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = createSession(sessionId);
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    private static Session createSession(String sessionId) {
        return new SessionImpl(sessionId);
    }

    public static void removeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.close();
            sessionMap.remove(sessionId);
        }
    }

    private interface Session {
        void close();
    }

    private static class SessionImpl implements Session {
        private String sessionId;

        public java_41613_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public void close() {
            // This method intentionally left empty to show the intention of the session manager.
        }
    }
}