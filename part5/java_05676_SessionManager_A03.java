import java.util.HashMap;
import java.util.Map;

public class java_05676_SessionManager_A03 {

    // A map to hold all sessions.
    private Map<String, Session> sessions;

    public java_05676_SessionManager_A03() {
        // Initialize the map.
        sessions = new HashMap<>();
    }

    // Method to add a session.
    public void addSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class.
    public static class Session {
        private String user;

        public java_05676_SessionManager_A03(String user) {
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