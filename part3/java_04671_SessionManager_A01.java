import java.util.ArrayList;

public class java_04671_SessionManager_A01 {
    private ArrayList<Session> sessions;
    private int currentId;

    public java_04671_SessionManager_A01() {
        sessions = new ArrayList<Session>();
        currentId = 0;
    }

    public Session createSession() {
        Session session = new Session(currentId);
        sessions.add(session);
        currentId++;
        return session;
    }

    public Session getSession(int id) {
        for (Session session : sessions) {
            if (session.getId() == id) {
                return session;
            }
        }
        return null; // Return null if session not found
    }

    public void removeSession(int id) {
        sessions.removeIf(session -> session.getId() == id);
    }

    private class Session {
        private int id;

        public java_04671_SessionManager_A01(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}