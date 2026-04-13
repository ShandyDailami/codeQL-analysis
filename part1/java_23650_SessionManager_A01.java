import java.util.HashMap;
import java.util.Map;

public class java_23650_SessionManager_A01 {

    private static int sessionCount = 0;
    private Map<Integer, Session> sessions;

    public java_23650_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        sessionCount++;
        Session session = new Session(sessionCount);
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(int sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(Session session) {
        sessions.remove(session.getId());
    }

    public class Session {
        private int id;

        public java_23650_SessionManager_A01(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        // other methods and operations related to session
    }
}