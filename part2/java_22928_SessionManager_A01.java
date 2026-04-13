import java.util.HashMap;
import java.util.Map;

public class java_22928_SessionManager_A01 {

    private Map<String, Session> sessionMap;

    public java_22928_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, new Session(sessionId));
        }
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public class Session {
        private String sessionId;

        public java_22928_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}