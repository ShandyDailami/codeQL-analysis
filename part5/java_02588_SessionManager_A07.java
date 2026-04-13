import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class java_02588_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_02588_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        Session session = new Session(userId);
        sessionMap.put(session.getId(), session);
        return session.getId();
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void expireSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String id;
        private Date creationTime;

        public java_02588_SessionManager_A07(String id) {
            this.id = id;
            this.creationTime = new Date();
        }

        public String getId() {
            return id;
        }

        public long getCreationTime() {
            return creationTime.getTime();
        }

        public boolean isValid() {
            long currentTime = new Date().getTime();
            long creationTime = this.creationTime.getTime();
            long sessionTimeout = 1000 * 60 * 10; // 10 minutes
            return (currentTime - creationTime) < sessionTimeout;
        }
    }
}