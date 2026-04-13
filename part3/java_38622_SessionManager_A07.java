import java.util.HashMap;

public class java_38622_SessionManager_A07 {
    private HashMap<String, UserSession> sessions;

    public java_38622_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UserSession createSession(String username) {
        UserSession session = new UserSession(username);
        sessions.put(username, session);
        return session;
    }

    public void terminateSession(String username) {
        sessions.remove(username);
    }

    public UserSession getSession(String username) {
        return sessions.get(username);
    }

    public class UserSession {
        private String username;

        public java_38622_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}