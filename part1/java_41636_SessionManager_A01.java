public class java_41636_SessionManager_A01 {
    private Session session;

    public void startSession() {
        session = new SessionImpl();
        session.start();
    }

    public void terminateSession() {
        session.terminate();
    }

    private interface Session {
        void start();
        void terminate();
    }

    private class SessionImpl implements Session {
        public void start() {
            System.out.println("Session started");
        }

        public void terminate() {
            System.out.println("Session terminated");
        }
    }
}