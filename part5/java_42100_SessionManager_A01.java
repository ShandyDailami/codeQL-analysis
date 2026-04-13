public class java_42100_SessionManager_A01 {

    private static int SESSION_ID = 0;
    private static final List<Session> sessions = new ArrayList<>();

    public static Session createSession() {
        Session session = new Session();
        session.setId(++SESSION_ID);
        sessions.add(session);
        return session;
    }

    public static void destroySession(Session session) {
        sessions.remove(session);
    }

    public static Session getSession(int sessionId) {
        for (Session s : sessions) {
            if (s.getId() == sessionId) {
                return s;
            }
        }
        return null;
    }

    public static boolean hasSession(int sessionId) {
        return getSession(sessionId) != null;
    }

    public static class Session {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}