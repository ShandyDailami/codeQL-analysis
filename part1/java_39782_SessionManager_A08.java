import java.util.HashMap;
import java.util.Map;

public class java_39782_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_39782_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void updateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.get(sessionId).setLastAccessed(System.currentTimeMillis());
        }
    }

    public static class Session {
        private String id;
        private long lastAccessed;

        public java_39782_SessionManager_A08(String id) {
            this.id = id;
            this.lastAccessed = System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getLastAccessed() {
            return lastAccessed;
        }

        public void setLastAccessed(long lastAccessed) {
            this.lastAccessed = lastAccessed;
        }
    }
}