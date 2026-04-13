public class java_39997_SessionManager_A03 {
    private static int sessionCount = 0;

    // Private constructor to prevent instantiation
    private java_39997_SessionManager_A03() {}

    public static Session getSession() {
        Session session = new SessionImpl();
        session.setSessionId(++sessionCount);
        return session;
    }

    // Session implementation
    private static class SessionImpl implements Session {
        private int sessionId;

        @Override
        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public int getSessionId() {
            return sessionId;
        }

        @Override
        public void beginTransaction() {
            System.out.println("Starting transaction for session: " + sessionId);
        }

        @Override
        public void commit() {
            System.out.println("Committing transaction for session: " + sessionId);
        }

        @Override
        public void rollback() {
            System.out.println("Rolling back transaction for session: " + sessionId);
        }

        @Override
        public void close() {
            System.out.println("Closing session: " + sessionId);
        }
    }
}