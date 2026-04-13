public class java_35866_SessionManager_A03 {
    private static int sessionCount = 0;

    private java_35866_SessionManager_A03() {}

    public static Session getSession() {
        sessionCount++;
        System.out.println("Session " + sessionCount + " created.");
        return new Session();
    }

    public static void closeSession(Session session) {
        sessionCount--;
        System.out.println("Session " + sessionCount + " closed.");
    }

    public static class Session {
        private boolean isOpen = true;

        public void close() {
            if (isOpen) {
                System.out.println("Closing session.");
                isOpen = false;
            } else {
                System.out.println("Session is already closed.");
            }
        }

        public void open() {
            if (!isOpen) {
                System.out.println("Opening session.");
                isOpen = true;
            } else {
                System.out.println("Session is already open.");
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        Session session = manager.getSession();
        session.open();
        session.close();

        manager.closeSession(session);
    }
}