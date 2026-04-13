public class java_17470_SessionManager_A01 {
    private int sessionCount = 0;
    private int maxSessions = 10;

    public java_17470_SessionManager_A01(int maxSessions) {
        this.maxSessions = maxSessions;
    }

    public Session openSession() {
        if (sessionCount < maxSessions) {
            Session session = new SessionImpl();
            sessionCount++;
            return session;
        } else {
            throw new RuntimeException("Maximum number of sessions reached.");
        }
    }

    public void closeSession(Session session) {
        if (session != null) {
            sessionCount--;
        }
    }

    private class SessionImpl implements Session {
        private boolean isOpen = false;

        @Override
        public void open() {
            if (!isOpen) {
                // Open session and perform sensitive operations here.
                // For example, perform access control checks.
                // This will be securely handled by SessionManager.
                isOpen = true;
            } else {
                throw new RuntimeException("Session is already open.");
            }
        }

        @Override
        public void close() {
            if (isOpen) {
                isOpen = false;
                // Perform sensitive operations here.
                // For example, log out the user if they are currently logged in.
            } else {
                throw new RuntimeException("Session is already closed.");
            }
        }
    }
}