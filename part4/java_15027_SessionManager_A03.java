import java.util.HashMap;
import java.util.Map;

public class java_15027_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_15027_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String startSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.close();
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String id;
        private boolean isActive;

        public java_15027_SessionManager_A03(String id) {
            this.id = id;
            this.isActive = true;
        }

        public void close() {
            isActive = false;
        }
    }
}