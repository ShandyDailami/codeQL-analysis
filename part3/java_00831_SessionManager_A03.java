import java.util.HashMap;
import java.util.Map;

public class java_00831_SessionManager_A03 {
    private static Map<String, Session> sessionMap = new HashMap<>();

    public static Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void createSession(String sessionId) {
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public static void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void updateSession(String sessionId) {
        destroySession(sessionId);
        createSession(sessionId);
    }

    private static class Session {
        private String sessionId;

        public java_00831_SessionManager_A03(String sessionId) {
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