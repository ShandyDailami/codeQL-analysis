import java.util.HashMap;
import java.util.Map;

public class java_09828_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_09828_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.put(session.username, session);
    }

    public Session getSession(String username) {
        return sessions.get(username);
    }

    public boolean isValidSession(String username) {
        Session session = getSession(username);
        return session != null && session.isValid();
    }

    public static class Session {
        private String username;
        private boolean valid;

        public java_09828_SessionManager_A01(String username) {
            this.username = username;
            this.valid = true; // Simulate a valid session
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }
    }
}