import java.util.*;

public class java_15805_SessionManager_A08 {
    private List<Session> sessions;
    private static int sessionCount = 0;

    public java_15805_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session session = new Session();
        session.setId(++sessionCount);
        sessions.add(session);
        return session;
    }

    public Session getSession(int id) {
        for (Session session : sessions) {
            if (session.getId() == id) {
                return session;
            }
        }
        return null;
    }

    public void deleteSession(int id) {
        Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            Session session = iterator.next();
            if (session.getId() == id) {
                iterator.remove();
                return;
            }
        }
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