public class java_34497_SessionManager_A01 {
    // Package-private for testing purposes
    static class Session {
        private boolean isOpen;

        Session() {
            this.isOpen = true;
        }

        void close() {
            this.isOpen = false;
        }
    }

    private Session session;

    public java_34497_SessionManager_A01() {
        this.session = new Session();
    }

    public void closeSession() {
        if (session.isOpen) {
            session.close();
        } else {
            throw new IllegalStateException("Session is closed");
        }
    }
}