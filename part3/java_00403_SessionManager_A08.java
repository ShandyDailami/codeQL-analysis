import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_00403_SessionManager_A08 {

    private Map<String, Session> sessionMap;

    public java_00403_SessionManager_A08() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.invalidate();
            sessionMap.remove(sessionId);
        }
    }

    public void updateSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.update();
        }
    }

    public class Session {

        private String id;
        private boolean valid;

        public java_00403_SessionManager_A08(String id) {
            this.id = id;
            this.valid = true;
        }

        public void invalidate() {
            valid = false;
        }

        public void update() {
            // In real scenario, you might want to update the session's data here
            valid = true;
        }
    }
}