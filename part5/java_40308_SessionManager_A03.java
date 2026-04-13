import java.util.HashMap;
import java.util.Map;

public class java_40308_SessionManager_A03 {
    // Use a Map to store sessions.
    private Map<String, Session> sessions;

    // Session class, containing username and session id.
    public class Session {
        private String username;

        public java_40308_SessionManager_A03(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }
    }

    public java_40308_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    // Add a session to the manager.
    public String addSession(String username) {
        if (sessions.containsKey(username)) {
            return null; // Return null or a unique key.
        }

        Session session = new Session(username);
        sessions.put(username, session);

        return session.getUsername();
    }

    // Remove a session from the manager.
    public boolean removeSession(String username) {
        if (!sessions.containsKey(username)) {
            return false; // Return false if the username does not exist.
        }

        sessions.remove(username);

        return true;
    }

    // Get a session from the manager.
    public Session getSession(String username) {
        return sessions.get(username);
    }
}