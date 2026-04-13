import java.util.LinkedHashMap;

public class java_39659_SessionManager_A07 {
    private LinkedHashMap<String, Session> sessions;

    public java_39659_SessionManager_A07() {
        sessions = new LinkedHashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void expireSessions() {
        sessions.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    private static class Session {
        private String id;
        private long creationTime;

        public java_39659_SessionManager_A07(String id) {
            this.id = id;
            this.creationTime = System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }

        public boolean isExpired() {
            long expirationTime = this.creationTime + 300000L; // 300 seconds
            return System.currentTimeMillis() > expirationTime;
        }
    }
}