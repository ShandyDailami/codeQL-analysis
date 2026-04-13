public class java_00390_SessionManager_A03 {
    private static int activeSessions = 0;

    public Session openSession() {
        Session session = new SessionImpl();
        activeSessions++;
        return session;
    }

    public void closeSession(Session session) {
        if (session instanceof SessionImpl) {
            activeSessions--;
        }
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    // Internal SessionImpl class.
    private static class SessionImpl implements Session {
        private boolean isOpen = false;

        public void close() {
            isOpen = false;
            SessionManager.this.closeSession(this);
        }

        public void open() {
            isOpen = true;
        }

        public boolean isOpen() {
            return isOpen;
        }
    }
}