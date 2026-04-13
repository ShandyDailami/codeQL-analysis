import java.util.HashMap;
import java.util.Map;

public class java_25590_SessionManager_A03 {
    // In a real application, this would be replaced with a more secure method to store sessions
    private static Map<String, Session> sessions = new HashMap<>();

    // Session class
    public static class Session {
        private String id;

        public java_25590_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    // Create a session
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Get a session
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Close a session
    public void closeSession(String id) {
        sessions.remove(id);
    }
}