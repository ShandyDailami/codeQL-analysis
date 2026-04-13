import java.util.HashMap;

public class java_08489_SessionManager_A07 {
    private HashMap<String, Session> sessionMap;

    public java_08489_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, Session session) {
        sessionMap.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class
    public class Session {
        private String user;

        public java_08489_SessionManager_A07(String user) {
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