import java.util.HashMap;
import java.util.Map;

public class java_20433_SessionManager_A01 {

    private Map<String, Session> sessionMap;

    public java_20433_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object obj) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        Session session = new Session(obj, sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).getObject();
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class Session {
        private Object obj;
        private String sessionId;

        public java_20433_SessionManager_A01(Object obj, String sessionId) {
            this.obj = obj;
            this.sessionId = sessionId;
        }

        public Object getObject() {
            return obj;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}