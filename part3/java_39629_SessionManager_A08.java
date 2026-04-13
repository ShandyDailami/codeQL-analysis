import java.util.concurrent.ConcurrentHashMap;

public class java_39629_SessionManager_A08 {
    private ConcurrentHashMap<String, Session> sessionMap;

    public java_39629_SessionManager_A08() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(Object user) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, user);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null || session.isExpired()) {
            return null;
        }
        return session.getUser();
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class Session {
        private String sessionId;
        private Object user;
        private long expirationTime;

        public java_39629_SessionManager_A08(String sessionId, Object user) {
            this.sessionId = sessionId;
            this.user = user;
            this.expirationTime = System.currentTimeMillis() + 10000L; // 10 second expiration time
        }

        public Object getUser() {
            return user;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }
    }
}