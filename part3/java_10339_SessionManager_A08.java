import java.util.HashMap;

public class java_10339_SessionManager_A08 {
    private HashMap<String, Session> sessionMap;

    public java_10339_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessionMap.put(sessionId, newSession);
            return newSession;
        }
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_10339_SessionManager_A08(String id) {
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