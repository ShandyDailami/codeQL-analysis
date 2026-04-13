import java.util.HashMap;
import java.util.Map;

public class java_23903_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_23903_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public void endSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.end();
            sessions.remove(sessionId);
        }
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.touch();
            return session;
        } else {
            throw new IllegalArgumentException("No session found with id " + sessionId);
        }
    }

    private class Session {
        private String id;
        private long creationTime;
        private long lastAccessedTime;

        public java_23903_SessionManager_A07(String id) {
            this.id = id;
            this.creationTime = System.currentTimeMillis();
            this.lastAccessedTime = this.creationTime;
        }

        public void touch() {
            this.lastAccessedTime = System.currentTimeMillis();
        }

        public void end() {
            this.creationTime = this.lastAccessedTime;
       
        }

        public long getCreationTime() {
            return creationTime;
        }

        public long getLastAccessedTime() {
            return lastAccessedTime;
        }

        public long getSessionTimeout() {
            return 60 * 1000; // 1 minute
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - this.creationTime > this.getSessionTimeout();
        }
    }
}