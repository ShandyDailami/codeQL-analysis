import java.util.HashMap;
import java.util.Map;

public class java_04466_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_04466_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String username) {
        if (!sessions.containsKey(username)) {
            sessions.put(username, new Session(username));
        }
        return sessions.get(username);
    }

    public void deleteSession(String username) {
        sessions.remove(username);
    }

    public static class Session {
        private String username;

        public java_04466_SessionManager_A03(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void validateSession(String password) {
            // Some security-sensitive operation related to injection
            // Here, the password is only printed for the sake of demonstration
            System.out.println("Validating session for user: " + this.username);
            System.out.println("Password: " + password);
        }
    }
}