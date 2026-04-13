import java.util.ArrayList;
import java.util.List;

public class java_23614_SessionManager_A03 {
    private List<Session> sessions;
    private int nextId;

    public java_23614_SessionManager_A03() {
        sessions = new ArrayList<>();
        nextId = 0;
    }

    public int createSession() {
        Session newSession = new Session(nextId);
        sessions.add(newSession);
        return nextId++;
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
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId() == id) {
                sessions.remove(i);
                return;
            }
        }
    }

    private class Session {
        private int id;

        public java_23614_SessionManager_A03(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}