import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class java_33899_SessionManager_A08 {
    private static List<Session> activeSessions = new ArrayList<>();

    public static class Session {
        private String id;
        private boolean isActive;

        public java_33899_SessionManager_A08(String id) {
            this.id = id;
            this.isActive = true;
        }

        public String getId() {
            return id;
        }

        public void closeSession() {
            this.isActive = false;
        }

        public boolean isActive() {
            return isActive;
        }
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        activeSessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.closeSession();
        }
    }

    public Session getSession(String sessionId) {
        for (Session session : activeSessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public void closeAllSessions() {
        for (Session session : activeSessions) {
            session.closeSession();
        }
        activeSessions.clear();
    }
}