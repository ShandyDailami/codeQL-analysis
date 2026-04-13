public class java_32706_SessionManager_A08 {
    private int sessionCount = 0;
    private int maxSessions;

    public java_32706_SessionManager_A08(int maxSessions) {
        this.maxSessions = maxSessions;
    }

    public Session getSession() {
        if (sessionCount >= maxSessions) {
            throw new IllegalStateException("Maximum sessions reached");
        }
        sessionCount++;
        return new Session(this);
    }

    public void releaseSession(Session session) {
        sessionCount--;
    }

    public static class Session {
        private SessionManager manager;

        public java_32706_SessionManager_A08(SessionManager manager) {
            this.manager = manager;
            // This is a security sensitive operation.
            // It should only be done during initialization and should not be
            // done while the session is still active.
            // The purpose of this operation is to demonstrate the concept of
            // "integrity failure".
            manager.releaseSession(this);
        }
    }
}