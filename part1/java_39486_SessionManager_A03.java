import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_39486_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_39486_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public List<Session> getAllSessions() {
        return new ArrayList<>(sessions.values());
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_39486_SessionManager_A03(String id) {
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

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.getSession("session1");
        Session session2 = sessionManager.getSession("session2");
        Session session3 = sessionManager.getSession("session3");

        sessionManager.getAllSessions().forEach(session -> System.out.println("Session ID: " + session.getId()));

        sessionManager.closeSession("session1");

        sessionManager.getAllSessions().forEach(session -> System.out.println("Session ID: " + session.getId()));
    }
}