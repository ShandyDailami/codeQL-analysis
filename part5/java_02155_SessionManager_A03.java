import java.util.HashMap;
import java.util.UUID;

public class java_02155_SessionManager_A03 {

    private HashMap<String, Session> sessionMap;

    public java_02155_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object object) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(object, sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Object getSessionObject(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            return null;
        }
        return session.getObject();
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class Session {

        private Object object;
        private String sessionId;

        public java_02155_SessionManager_A03(Object object, String sessionId) {
            this.object = object;
            this.sessionId = sessionId;
        }

        public Object getObject() {
            return object;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}