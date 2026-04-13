public class java_03932_SessionManager_A01 {
    private static int currentSessionId = 0;
    private static List<Session> sessions = new ArrayList<>();

    public static Session createSession() {
        Session session = new Session();
        session.setId(++currentSessionId);
        sessions.add(session);
        return session;
    }

    public static void closeSession(Session session) {
        sessions.remove(session);
    }

    public static Session getSession(int id) {
        for (Session session : sessions) {
            if (session.getId() == id) {
                return session;
            }
        }
        return null;
    }
}

class Session {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}