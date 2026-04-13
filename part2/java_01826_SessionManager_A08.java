public class java_01826_SessionManager_A08 {
    private static final List<Session> sessions = new ArrayList<>();

    public static Session getSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public static void closeSession(Session session) {
        sessions.remove(session);
    }

    public static boolean isSessionIntegritySafe() {
        // Check if all sessions are still active after integrity failure
        for (Session session : sessions) {
            if (session.isActive()) {
                return false;
            }
        }
        return true;
    }

    private static class Session {
        private boolean isActive = true;

        public boolean isActive() {
            return isActive;
        }

        public void close() {
            isActive = false;
        }
    }
}