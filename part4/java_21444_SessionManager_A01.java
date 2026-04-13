import java.util.HashMap;
import java.util.Map;

public class java_21444_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    public java_21444_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_21444_SessionManager_A01(String id) {
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