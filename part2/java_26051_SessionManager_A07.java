public class java_26051_SessionManager_A07 {
    private static int sessionIdCounter = 0;
    private static List<Session> sessions = new ArrayList<>();

    public static class Session {
        private int id;
        private boolean isActive;

        public java_26051_SessionManager_A07(int id) {
            this.id = id;
            this.isActive = true;
        }

        public void close() {
            this.isActive = false;
        }
    }

    public Session createSession() {
        Session session = new Session(sessionIdCounter++);
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        session.close();
        sessions.remove(session);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.createSession();
        System.out.println("Created session with ID: " + session1.id);

        Session session2 = sessionManager.createSession();
        System.out.println("Created session with ID: " + session2.id);

        sessionManager.closeSession(session1);
        System.out.println("Closed session with ID: " + session1.id);

        sessionManager.closeSession(session2);
        System.out.println("Closed session with ID: " + session2.id);
    }
}