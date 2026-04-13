import java.util.concurrent.ConcurrentHashMap;

public class java_12365_SessionManager_A07 {

    private ConcurrentHashMap<String, Session> sessions;

    public java_12365_SessionManager_A07() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.remove(sessionId);

        if (session == null) {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
    }

    private class Session {
        private String id;

        public java_12365_SessionManager_A07(String id) {
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