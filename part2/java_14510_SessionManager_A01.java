import java.util.ArrayList;
import java.util.List;

public class java_14510_SessionManager_A01 {

    private List<Session> sessions;

    public java_14510_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.add(session);
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }

    public void deleteAllSessions() {
        sessions.clear();
    }

    public static class Session {
        private String id;

        public java_14510_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}