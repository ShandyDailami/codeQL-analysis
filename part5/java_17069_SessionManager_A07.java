import java.util.HashMap;

public class java_17069_SessionManager_A07 {
    private HashMap<String, Session> sessions;

    public java_17069_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public boolean isActiveSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return true;
        }
        return false;
    }

    public class Session {
        private String id;

        public java_17069_SessionManager_A07() {
            this.id = java.util.UUID.randomUUID().toString();
        }

        public String getId() {
            return id;
        }
    }
}