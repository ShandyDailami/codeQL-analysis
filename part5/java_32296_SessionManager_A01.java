import java.util.HashMap;

public class java_32296_SessionManager_A01 {
    private HashMap<String, UserSession> sessions;

    public java_32296_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, UserSession userSession) {
        sessions.put(sessionId, userSession);
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class UserSession {
        private String username;
        private String password;

        public java_32296_SessionManager_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}