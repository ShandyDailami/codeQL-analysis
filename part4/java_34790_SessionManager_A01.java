public class java_34790_SessionManager_A01 {

    private static int currentSessionId = 0;
    private static List<Session> sessions = new ArrayList<>();

    public static class Session {
        private int id;
        private boolean isActive;

        public java_34790_SessionManager_A01(int id) {
            this.id = id;
            this.isActive = true;
        }

        public int getId() {
            return id;
        }

        public void close() {
            this.isActive = false;
        }
    }

    public Session createSession() {
        Session session = new Session(currentSessionId);
        sessions.add(session);
        currentSessionId++;
        return session;
    }

    public void closeSession(Session session) {
        if (session != null && session.isActive) {
            session.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.createSession();
        Session session2 = sessionManager.createSession();
        Session session3 = sessionManager.createSession();

        sessionManager.closeSession(session2);

        // This will print: [0, 1, 2]
        sessions.stream().map(Session::getId).forEach(System.out::println);
    }
}