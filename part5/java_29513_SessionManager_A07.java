import java.util.HashMap;
import java.util.Map;

public class java_29513_SessionManager_A07 {
    // Create a session factory
    private static Map<String, Session> sessions = new HashMap<>();

    // Create a session
    public static Session createSession(String username) {
        Session session = new Session();
        session.setUsername(username);
        sessions.put(username, session);
        return session;
    }

    // Get a session
    public static Session getSession(String username) {
        return sessions.get(username);
    }

    // Close a session
    public static void closeSession(String username) {
        sessions.remove(username);
    }

    // Session class
    public static class Session {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}