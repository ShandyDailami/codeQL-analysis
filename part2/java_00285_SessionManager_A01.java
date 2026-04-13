import java.util.ArrayList;
import java.util.List;

public class java_00285_SessionManager_A01 {

    private List<Session> sessions;
    private static int sessionIdCounter = 0;

    public java_00285_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session session = new Session();
        session.setId(generateSessionId());
        sessions.add(session);
        return session;
    }

    public Session getSession(int sessionId) {
        for (Session session : sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        return null;
    }

    public void deleteSession(int sessionId) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId() == sessionId) {
                sessions.remove(i);
                break;
            }
        }
    }

    private int generateSessionId() {
        return sessionIdCounter++;
    }

    private class Session {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}