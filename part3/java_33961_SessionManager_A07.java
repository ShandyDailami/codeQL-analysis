import java.util.HashMap;
import java.util.Map;

public class java_33961_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_33961_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session startSession() {
        String sessionKey = String.valueOf(System.currentTimeMillis());
        Session session = new Session(sessionKey);
        sessions.put(sessionKey, session);
        return session;
    }

    public Session getSession(String sessionKey) {
        return sessions.get(sessionKey);
    }

    public void closeSession(String sessionKey) {
        sessions.remove(sessionKey);
    }

    public static class Session {
        private String sessionKey;

        public java_33961_SessionManager_A07(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }
    }
}