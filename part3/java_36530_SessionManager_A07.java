import java.util.HashMap;
import java.util.Map;

public class java_36530_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_36530_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        Session session = new Session();
        sessionMap.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String user;

        public java_36530_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}